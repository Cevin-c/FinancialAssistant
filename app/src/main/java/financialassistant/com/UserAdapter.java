package financialassistant.com;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends

        RecyclerView.Adapter<UserAdapter.viewholder>

{

    List<Userclass> userArrayList = new ArrayList<>();
    Context mContext;

    public UserAdapter(Context context) {
       this. mContext = context;
    }
    @Override
    public viewholder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        Context context = parent.getContext();

        int id = R.layout.viewholder;

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = layoutInflater.inflate(id, parent, shouldAttachToParentImmediately);

        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(viewholder holder, int position)
    {
        Userclass user = userArrayList.get(position);

        holder.description.setText(user.getdescription());
        holder.duedate.setText(user.getduedate());
        holder.dateborrowed.setText(user.getdateborrowed());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setUserArrayList(List<Userclass> userArrayList) {
        this.userArrayList = userArrayList;
        notifyDataSetChanged();
    }

    class viewholder extends RecyclerView.ViewHolder{
        TextView description;
        TextView duedate;
        TextView dateborrowed;

        public viewholder(View itemView) {
            super(itemView);
           description = itemView.findViewById(R.id.editText4);
           duedate = itemView.findViewById(R.id.editText5);
          dateborrowed = itemView.findViewById(R.id.editText6);

        }

    }

}
