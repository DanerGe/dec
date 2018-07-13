package dec.demo.pojo;

public class WebSocketBean {
    public String message;

    public String date;

    public WebSocketBean(String message, String date) {
        this.message = message;
        this.date = date;
    }

    public WebSocketBean() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "WebSocketBean{" +
                "message='" + message + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
