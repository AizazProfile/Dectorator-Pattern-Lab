package Labtask.FileDecorator;




import java.io.File;

public class Demo {
    public static void main(String[] args) {
        // Create output directory if it doesn't exist
        File outputDir = new File("output");
        if (!outputDir.exists()) {
            outputDir.mkdir();
        }

        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000\n中文测试";

        try {
            // Define file paths
            String outputPath = "output/output.txt";
            String demoPath = "output/OutputDemo.txt";
            String utf8Path = "output/OutputUtf8Demo.txt";

            // 1. Original demo
            DataSourceDecorator encoded = new CompressionDecorator(
                    new EncryptionDecorator(
                            new FileDataSource(demoPath)));

            // 2. UTF-8 demo
            DataSourceDecorator utf8Encoded = new UTF8Decorator(
                    new CompressionDecorator(
                            new EncryptionDecorator(
                                    new FileDataSource(utf8Path))));

            // Write data
            encoded.writeData(salaryRecords);
            utf8Encoded.writeData(salaryRecords);

            // Read data back
            DataSource plainDemo = new FileDataSource(demoPath);
            DataSource plainUtf8 = new FileDataSource(utf8Path);

            System.out.println("- Input ----------------");
            System.out.println(salaryRecords);

            System.out.println("\n- Encoded (Original) ----");
            System.out.println(plainDemo.readData());

            System.out.println("\n- Encoded (UTF-8) ------");
            System.out.println(plainUtf8.readData());

            System.out.println("\n- Decoded (Original) ---");
            System.out.println(encoded.readData());

            System.out.println("\n- Decoded (UTF-8) ------");
            System.out.println(utf8Encoded.readData());

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
            System.err.println("\nTroubleshooting tips:");
            System.err.println("1. Check if 'output' directory exists");
            System.err.println("2. Verify write permissions in project directory");
            System.err.println("3. Make sure files aren't locked by another process");
        }
    }
}