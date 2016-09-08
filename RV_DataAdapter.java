public class RV_DataAdapter extends RecyclerView.Adapter<RV_DataAdapterViewHolder> {


    private ArrayList <ProductData> arrayList;
    private context mcontent;
    //Rv_DataAdapter class constructor that inialize the array List
    @Oveeide
    public RV_DataAdapter(context context, ArrayList<ProductData> android) {
        this.arrayList = android;
        this.mcontent = context;
    }

    //confiqure the adapter product text and image resource to the adapter
    @Override
    public void onBindViewHolder(RV_DataAdapter.viewHolder holder, in i) {
        holder.textView.setText(arrayList.get(i).getrecyclerViewImage());
        holder.imageView.setImageResource(arrayList.get(i).getrecyclerViewImage());

    }


    //Adapter display/inflates the grid layout file with Image and titles
    @Override
    public RV_DataAdapter.viewHolder onCreateViewHolder(ViewGroup vGroup, int i) {
        View view = layoutInflater.from(vGroup.getContext()).inflate(R.layout.products_grid_diplay, vGroup,false);
        return new ViewHolder(view);
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }



    public class viewHolder extends recyclerview.ViewHolder {
        private TextView textView;
        private ImageView;

        public viewHolder(View v) {
            super(v);

            textView = (Textview) v.findViewById(R.id.producttext);
            imageView = (ImageView) v.findviewById(R.id.productimage);
        }
    }//Ends ViewHolder class
}







