# NotificationButton

##一个显示红点通知的android Button

![img](https://github.com/ws123/NotificationButton/blob/master/ex.png)

#Usage
---
Add the dependency to your build.gradle.
```
dependencies {
    compile 'com.carlos.notificatoinbutton:buttonlibrary:1.0.5'
}
```
Add the NotificationButton to your layout.

```xml
    <com.carlos.notificatoinbutton.library.NotificationButton
        android:id="@+id/button2"
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:layout_marginTop="15dp"
        android:background="@mipmap/wechat"
        notButton:circleBgColor="@android:color/holo_red_light"
        notButton:circleSize="12dp"
        notButton:textColor="@android:color/white" />
```
Setup with your java file.
```Java
@Override  
   protected void onCreate(Bundle savedInstanceState) {  
       super.onCreate(savedInstanceState);  
       setContentView(R.layout.activity_main);  
       button2 = (NotificationButton) findViewById(R.id.button2);  
       button3 = (NotificationButton) findViewById(R.id.button3);  
       button4 = (NotificationButton) findViewById(R.id.button4);  
       button5 = (NotificationButton) findViewById(R.id.button5);  
       button2.setNotificationNumber(120);  
       button3.setNotificationNumber(85);  
       button4.setNotificationNumber(9);  
       button5.setNotificationNumber(0);  
   }
```
```XML
        <!--小红点的颜色-->  
        notButton:circleBgColor="@android:color/holo_red_light"  
        <!--小红点大小-->  
        notButton:circleSize="12dp"  
        <!--小红点上字的颜色-->  
        notButton:textColor="@android:color/holo_green_dark"  
```

Developed By
---
 * QQ：372532647

License
---

    Copyright 2015 carlos

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

