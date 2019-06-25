package financialassistant.com;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TodoAdapter extends

        RecyclerView.Adapter<TodoAdapter.viewholder>

{

    List<Todoclass> todoclassArrayList = new ArrayList<>();
    Context mContext;

    public TodoAdapter(Context context) {
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
        Todoclass todoclass = todoclassArrayList.get(position);

        holder.description.setText(todoclass.getdescription());
        holder.date.setText(todoclass.getdate());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setTodoclassArrayList(List<Todoclass> todoclassArrayList) {
        this.todoclassArrayList = todoclassArrayList;
        notifyDataSetChanged();
    }

    class viewholder extends RecyclerView.ViewHolder{
        TextView description;
        TextView date;

        public viewholder(View itemView) {
            super(itemView);
            description = itemView.findViewById(R.id.editText4);
            date = itemView.findViewById(R.id.editText5);


        }

    }

}
