

//define items which in my list View and i want to pass data to my layout
    public class AdapterItems
    {
        public  int iD;
        public  String jobTitle;
        public  String description;

        //for news details
        AdapterItems( int id, String jobTitle,String description){
            this.iD = id;
            this.jobTitle= jobTitle;
            this.description= description;
        }

    }


    //Adapter class .. display new list
    /** an Adapter that pulls content from a source such as an array or
     * database query and converts each item result into a view that's placed into the list.*/
     
    private class MyCustomAdapter extends BaseAdapter {
        public ArrayList<AdapterItems> listNewsDataAdapter ;

        public MyCustomAdapter(ArrayList<AdapterItems>  listnewsDataAdapter) {
            this.listNewsDataAdapter=listnewsDataAdapter;
        }
        
        @Override
        public int getCount() {
            return listNewsDataAdapter.size();
        }

        @Override
        public String getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

//        call specific layout and display it in my list
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            //connect to another layout by inflater
            LayoutInflater Inflater = getLayoutInflater();
            View myView = Inflater.inflate(R.layout.layout_ticket, null);

//            create object
            final AdapterItems items = listNewsDataAdapter.get(position);

            TextView txtId =(TextView) myView.findViewById(R.id.txtId);
            txtId.setText("id: "+ s.iD);

            TextView txtTitle=( TextView)myView.findViewById(R.id.txtTitle);
            txtTitle.setText(items.jobTitle);
            
            TextView txtDesc=( TextView)myView.findViewById(R.id.txtDesc);
            txtDesc.setText(items.description);

            return myView;
        }

    }//end of class MyCustomAdapter
    


    //adapter class
    ArrayList<AdapterItems> listNewsData = new ArrayList<>();
    MyCustomAdapter myAdapter;
    ListView listView;
 
    //access on my listView
    listView = (ListView) findViewById(R.id.listView);
    //add data and view it
    listNewsData.add(new AdapterItems(1,"admin","develop apps"));

    //pass arrayList to Adapter
    myAdapter=new MyCustomAdapter(listNewsData);
    //display that Adapter in listView
    listView.setAdapter(myAdapter);

    //update  data in listview
    listnewsData.add(new AdapterItems(2,"tester"," test apps"));
    myadapter.notifyDataSetChanged();

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
