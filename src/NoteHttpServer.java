import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

// Для добавления заметки, запустите сервер и в терминале введите команду:
// curl -X POST http://localhost:8080/add -d "First note"

// Просмотр заметок доступен либо по ссылке в браузере, либо по команде:
// curl http://localhost:8080/notes

// Замена осуществляется по индексу следующей командой:
// curl -X POST "http://localhost:8080/edit?index=0&text=New_first_note"
public class NoteHttpServer {
    private static final int PORT = 8080;
    private static final List<String> notes = new ArrayList<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Note HTTP Server запущен на порту " + PORT);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    // Чтение заголовков
                    String inputLine;
                    StringBuilder headers = new StringBuilder();
                    while ((inputLine = in.readLine()) != null && !inputLine.isEmpty()) {
                        headers.append(inputLine).append("\n");
                    }

                    // Разбор заголовков
                    String[] headerLines = headers.toString().split("\n");
                    String requestLine = headerLines[0];
                    String[] parts = requestLine.split(" ");
                    String method = parts[0];
                    String path = parts[1];

                    // Извлечение пути и параметров
                    URI uri = new URI(path);
                    String pathWithoutQuery = uri.getPath();
                    String query = uri.getQuery();

                    // Определение Content-Length
                    int contentLength = 0;
                    for (String line : headerLines) {
                        if (line.toLowerCase().startsWith("content-length:")) {
                            try {
                                contentLength = Integer.parseInt(line.substring("content-length:".length()).trim());
                            } catch (NumberFormatException e) {
                                // Если не удалось расарсить, считаем длину 0
                                contentLength = 0;
                            }
                            break;
                        }
                    }

                    // Чтение тела запроса
                    String requestBody = "";
                    if (contentLength > 0) {
                        char[] bodyBuffer = new char[contentLength];
                        int bytesRead = 0;
                        boolean connectionClosed = false;
                        while (bytesRead < contentLength) {
                            int read = in.read(bodyBuffer, bytesRead, contentLength - bytesRead);
                            if (read == -1) {
                                // Клиент закрыл соединение раньше времени
                                System.err.println("Клиент закрыл соединение до отправки всего тела запроса.");
                                connectionClosed = true;
                                break;
                            }
                            bytesRead += read;
                        }
                        if (!connectionClosed) {
                            requestBody = new String(bodyBuffer, 0, bytesRead);
                        } else {
                            // Если тело не удалось прочитать полностью, можно вернуть ошибку
                            // Но для простоты просто присвоим пустую строку, и логика дальше сама решит, что с этим делать
                            requestBody = "";
                        }
                    }

                    String response;

                    if (method.equals("GET") && pathWithoutQuery.equals("/notes")) {
                        response = "HTTP/1.1 200 OK\r\n" +
                                "Content-Type: text/html\r\n" +
                                "\r\n" +
                                "<html><body><h1>Notes</h1><ul>";
                        for (int i = 0; i < notes.size(); i++) {
                            response += "<li>[" + i + "] " + notes.get(i) + "</li>";
                        }
                        response += "</ul></body></html>";
                    } else if (method.equals("POST") && pathWithoutQuery.equals("/add")) {
                        // Для /add используем тело запроса
                        String note = requestBody.trim();
                        if (!note.isEmpty()) {
                            notes.add(note);
                            response = "HTTP/1.1 200 OK\r\n" +
                                    "Content-Type: text/html\r\n" +
                                    "\r\n" +
                                    "<html><body><h1>Note added</h1></body></html>";
                        } else {
                            response = "HTTP/1.1 400 Bad Request\r\n" +
                                    "Content-Type: text/html\r\n" +
                                    "\r\n" +
                                    "<html><body><h1>Empty note</h1></body></html>";
                        }
                    } else if (method.equals("POST") && pathWithoutQuery.equals("/remove")) {
                        if (!notes.isEmpty()) {
                            notes.remove(notes.size() - 1);
                            response = "HTTP/1.1 200 OK\r\n" +
                                    "Content-Type: text/html\r\n" +
                                    "\r\n" +
                                    "<html><body><h1>Last note removed</h1></body></html>";
                        } else {
                            response = "HTTP/1.1 400 Bad Request\r\n" +
                                    "Content-Type: text/html\r\n" +
                                    "\r\n" +
                                    "<html><body><h1>No notes to remove</h1></body></html>";
                        }
                    } else if (method.equals("POST") && pathWithoutQuery.equals("/edit")) {
                        // Для /edit используем параметры из query string
                        Map<String, String> params = parseQuery(query);
                        String indexParam = params.get("index");
                        String textParam = params.get("text");

                        if (indexParam == null || textParam == null) {
                            response = "HTTP/1.1 400 Bad Request\r\n" +
                                    "Content-Type: text/html\r\n" +
                                    "\r\n" +
                                    "<html><body><h1>Missing index or text parameter</h1></body></html>";
                        } else {
                            try {
                                int index = Integer.parseInt(indexParam);
                                // Проверяем индекс: неотрицательный и в пределах списка
                                if (index < 0 || index >= notes.size()) {
                                    response = "HTTP/1.1 400 Bad Request\r\n" +
                                            "Content-Type: text/html\r\n" +
                                            "\r\n" +
                                            "<html><body><h1>Invalid index: " + index + "</h1></body></html>";
                                } else if (textParam.trim().isEmpty()) {
                                    response = "HTTP/1.1 400 Bad Request\r\n" +
                                            "Content-Type: text/html\r\n" +
                                            "\r\n" +
                                            "<html><body><h1>Text cannot be empty</h1></body></html>";
                                } else {
                                    // Редактируем заметку
                                    notes.set(index, textParam.trim());
                                    response = "HTTP/1.1 200 OK\r\n" +
                                            "Content-Type: text/html\r\n" +
                                            "\r\n" +
                                            "<html><body><h1>Note at index " + index + " updated</h1></body></html>";
                                }
                            } catch (NumberFormatException e) {
                                response = "HTTP/1.1 400 Bad Request\r\n" +
                                        "Content-Type: text/html\r\n" +
                                        "\r\n" +
                                        "<html><body><h1>Invalid index format: " + indexParam + "</h1></body></html>";
                            }
                        }
                    } else {
                        response = "HTTP/1.1 404 Not Found\r\n" +
                                "Content-Type: text/html\r\n" +
                                "\r\n" +
                                "<html><body><h1>404 Not Found</h1></body></html>";
                    }

                    out.print(response);
                    out.flush(); // Убедимся, что ответ отправлен

                } catch (IOException | URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Вспомогательный метод для парсинга query string
    private static Map<String, String> parseQuery(String query) {
        Map<String, String> params = new HashMap<>();
        if (query != null) {
            String[] pairs = query.split("&");
            for (String pair : pairs) {
                int idx = pair.indexOf("=");
                if (idx > 0) {
                    try {
                        String key = URLDecoder.decode(pair.substring(0, idx), StandardCharsets.UTF_8);
                        String value = URLDecoder.decode(pair.substring(idx + 1), StandardCharsets.UTF_8);
                        params.put(key, value);
                    } catch (IllegalArgumentException e) {
                        System.err.println("Ошибка декодирования параметра: " + pair);
                    }
                }
            }
        }
        return params;
    }
}