
/** Code dangerous Permission uses in MainActivity & Manifest  */

/* Permissions in manifest file ----- 
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"></uses-permission>
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"></uses-permission>
    <uses-permission android:name="android.permission.READ_CONTACTS"></uses-permission>
    */


    //access to Permissions
    void checkUserPermissions(){
        //check Version
        if ( Build.VERSION.SDK_INT >= 23){
            //check if  my app have this permission granted previously ?? or this first time ?!
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) !=
                    PackageManager.PERMISSION_GRANTED ){
                //Display Screen to request perm from the user
                requestPermissions(new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION },
                        REQUEST_CODE_ASK_PERMISSIONS);
                return ;
            }
        }
        getLastLocation();
    }

    //every permission have a unique code where the method might have array of permission
    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;

    //get response from the user
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                //if the user accepted
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getLastLocation();
                } else {
                    // Permission Denied
                    Toast.makeText( this,"you deny location access" , Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }



    //get last location
    void getLastLocation(){
        LocationManager lm = (LocationManager) getSystemService(LOCATION_SERVICE);
        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        txtLocation.setText("Longitude = "+ String.valueOf(location.getLongitude()) +
                "Altitude = "+String.valueOf(location.getLatitude()));
    }


    void readContacts(){
        //read name, telephone
        //extract data from another App via ContentProvider
        Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI ,
                null, null, null, null);

        //loop to retrieve data  with row by row
        if (cursor.moveToFirst() /*This method will return false if the cursor is empty*/){
            do{
                //bring data from DB in that arrayList ..
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String tel = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                contactList.add(new ContactItems(name, tel));

            }while (cursor.moveToNext());
            /** Move the cursor to the next row.
             This method will return false if the cursor is already past the last entry in the result set.*/
        }
    }//end of readContacts Method




