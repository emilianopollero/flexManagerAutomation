package common.utils

@Singleton(strict = false)
class FlexManagerPropertyReader {
    @Delegate
    private Properties props = new Properties()
    private FlexManagerPropertyReader () {
        FileInputStream input
        try {
            input = new FileInputStream("src/test/resources/labs_env.properties")
            props.load(input)
            input.close()
        } catch (IOException ex) {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace()
                }
                ex.printStackTrace()
            }
        }
    }

    public String readProperty(String key) {
        return props.getProperty(key);
    }
}