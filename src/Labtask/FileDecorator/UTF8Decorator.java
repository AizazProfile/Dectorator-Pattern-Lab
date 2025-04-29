package Labtask.FileDecorator;




import java.io.UnsupportedEncodingException;

    public class UTF8Decorator extends DataSourceDecorator {

        public UTF8Decorator(DataSource source) {
            super(source);
        }

        @Override
        public void writeData(String data) {
            try {
                // Ensure UTF-8 encoding
                super.writeData(new String(data.getBytes("UTF-8"), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                System.out.println("UTF-8 encoding not supported: " + e.getMessage());
                super.writeData(data);
            }
        }

        @Override
        public String readData() {
            String data = super.readData();
            try {
                // Ensure proper UTF-8 decoding
                return new String(data.getBytes("ISO-8859-1"), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                System.out.println("UTF-8 decoding not supported: " + e.getMessage());
                return data;
            }
        }
    }

