## DAT110 - Project 2: Publish-subscribe messaging middleware

### Organisation

Aahed Diyab - 588408

Olav Pete - 588249

### Screenshots of running project

Broker:
![](assets/Broker.png)

Getting ChApp to work with IntelliJ:
```
module project_2 {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires gson;
    requires java.sql;

    opens no.hvl.dat110.chapp;
    opens no.hvl.dat110.messages;
}
```

Olav's ChApp:
![](assets/Olav_Connection.png)
Aahed's ChApp:
![](assets/Aahed_Connection.png)

### Screenshots of running tests

TestStorage:
![](assets/TestStorage.png)
Test1ConnectDisconnect:
![](assets/Test1ConnectDisconnect.png)
Test2Reconnect:
![](assets/Test2Reconnect.png)
Test3MultipleConnections:
![](assets/Test3MultipleConnections.png)
Test4CreateDelete:
![](assets/Test4CreateDelete.png)
Test5Subscribe:
![](assets/Test5Subscribe.png)
Test6Publish:
![](assets/Test6Publish.png)
Test7MultiPublish:
![](assets/Test7MultiPublish.png)


