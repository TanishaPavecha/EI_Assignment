// Product interface
interface Notification {
    void notifyUser();
}

// Concrete Product for Email Notification
class EmailNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending an email notification.");
    }
}

// Concrete Product for SMS Notification
class SMSNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending an SMS notification.");
    }
}

// Concrete Product for Push Notification
class PushNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending a push notification.");
    }
}

// Creator/Factory class
abstract class NotificationFactory {
    public abstract Notification createNotification();

    public void notifyUser() {
        Notification notification = createNotification();
        notification.notifyUser();
    }
}

// Concrete Factory for Email
class EmailNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}

// Concrete Factory for SMS
class SMSNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}

// Concrete Factory for Push Notification
class PushNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new PushNotification();
    }
}

// Demonstration of Factory Method Pattern
public class FactoryMethodPatternDemo {
    public static void main(String[] args) {
        NotificationFactory factory;

        // Choose to send an Email notification
        factory = new EmailNotificationFactory();
        factory.notifyUser();

        // Choose to send an SMS notification
        factory = new SMSNotificationFactory();
        factory.notifyUser();

        // Choose to send a Push notification
        factory = new PushNotificationFactory();
        factory.notifyUser();
    }
}
