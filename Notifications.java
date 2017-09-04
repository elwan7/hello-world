 
 int notId = 0;
 //1st way: little complex

        //build my Notification
        NotificationCompat.Builder nBuild = new NotificationCompat.Builder(this);
        //set properties
        nBuild.setContentTitle("dangerous")
                .setContentText("it will run soon!")
                .setSmallIcon(R.drawable.caution2);
        //display my Notify
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(notId, nBuild.build());
        notId++;
