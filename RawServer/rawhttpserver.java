import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.concurrent.*;

public class RawHttpServer {
    private static final int PORT = 8080;
    // Bounded thread pool so we don't crash the JVM with too many threads
    private static final ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("🚀 Server running on http://localhost:" + PORT);

        while (true) {
            // 1. Block and wait for a connection
            Socket clientSocket = serverSocket.accept();
            
            // 2. Pass the socket to a background thread
            threadPool.submit(() -> handleClient(clientSocket));
        }
    }

    private static void handleClient(Socket socket) {
        // try-with-resources ensures the socket and streams are closed automatically!
        try (
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"))
        ) {
            // TODO 1: Read the first line of the request (e.g., "GET /api/data HTTP/1.1")
            
            // TODO 2: Split the string to extract the HTTP Method and the URI Path

            // TODO 3: Implement basic routing logic (if/else on the URI)
            // Route A: If path is "/", return a hardcoded HTML string.
            // Route B: If path is "/api/data", return a hardcoded JSON string: {"status": "active", "dev": "sahil"}

            // TODO 4: Construct the raw HTTP response as a String.
            // Remember the exact format:
            // HTTP/1.1 200 OK\r\n
            // Content-Type: application/json\r\n
            // Content-Length: <length_of_your_payload_bytes>\r\n
            // \r\n
            // <your payload>

            // TODO 5: Convert your response string to bytes and write it to the output stream. out.write(...); out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 
