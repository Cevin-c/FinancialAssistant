package financialassistant.com;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecurrentexpensesAdapter extends

        RecyclerView.Adapter<RecurrentexpensesAdapter.viewholder>

{

    List<Reccurentexpensesclass> reccurentexpensesclassArrayList = new ArrayList<>();
    Context mContext;

    public RecurrentexpensesAdapter(Context context) {
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
        Reccurentexpensesclass reccurentexpensesclass = reccurentexpensesclassArrayList.get(position);

        holder.description.setText(reccurentexpensesclass.getdescription());
        holder.amount.setText(reccurentexpensesclass.getamount());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setReccurentexpensesclassArrayList(List<Reccurentexpensesclass> reccurentexpensesclassArrayList) {
        this.reccurentexpensesclassArrayList = reccurentexpensesclassArrayList;
        notifyDataSetChanged();
    }

    class viewholder extends RecyclerView.ViewHolder{
        TextView description;
        TextView amount;

        public viewholder(View itemView) {
            super(itemView);
            description = itemView.findViewById(R.id.editText4);
            amount = itemView.findViewById(R.id.editText6);

        }

    }

}
