package Labtask.FileDecorator;




import java.io.*;

    public class FileDataSource implements DataSource {
        private String name;

        public FileDataSource(String name) {
            this.name = name;
        }

        @Override
        public void writeData(String data) {
            File file = new File(name);
            try (OutputStream fos = new FileOutputStream(file)) {
                fos.write(data.getBytes("UTF-8"), 0, data.length());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

        @Override
        public String readData() {
            try (InputStream fis = new FileInputStream(name);
                 InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
                 BufferedReader reader = new BufferedReader(isr)) {

                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                return content.toString();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                return "";
            }
        }
    }

