package Connector;

public class ConnectionDetails {

    private String userName ;
    private String hostName ;
    private int port ;
    private String password ;
    private String key ;
    private String directory ;

    public ConnectionDetails (String userName, String hostName, int port, String password, String key, String directory) {
        this.userName = userName;
        this.hostName = hostName;
        this.port = port;
        this.password = password;
        this.key = key;
        this.directory = directory;
    }

    public String getUserName() {
        return userName;
    }

    public String getHostName() {
        return hostName;
    }

    public int getPort() {
        return port;
    }

    public String getKey() {
        return key;
    }

    public String getPassword() {
        return password;
    }

    public String getDirectory() {
        return directory;
    }
}
