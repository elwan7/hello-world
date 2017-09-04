
        //1st way: little complex

        int notId = 0;
        //build my Notification
        NotificationCompat.Builder nBuild = new NotificationCompat.Builder(this);
        //set properties
        nBuild.setContentTitle("dangerous")
                .setContentText("it will run soon!")
                .setSmallIcon(R.drawable.caution2);
        //display my Notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(notId, nBuild.build());
        notId++;

        //2nd way: simple

        
