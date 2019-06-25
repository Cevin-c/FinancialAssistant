package financialassistant.com;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class IncomeAdapter extends RecyclerView.Adapter<IncomeAdapter.viewholder>

{

    List<Incomeclass> incomeclassArrayList = new ArrayList<>();
    Context mContext;

    public IncomeAdapter(Context context) {
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
        Incomeclass incomeclass = incomeclassArrayList.get(position);

        holder.description.setText(incomeclass.getdescription());
        holder.date.setText(incomeclass.getdate());
        holder.amount.setText(incomeclass.getamount());
    }

    @Override
    public int getItemCount() {
        return incomeclassArrayList.size();
    }

    public void setIncomeclassArrayList(List<Incomeclass> incomeclassArrayList) {
        this.incomeclassArrayList = incomeclassArrayList;
        notifyDataSetChanged();
    }

    class viewholder extends RecyclerView.ViewHolder{
        TextView description;
        TextView date;
        TextView amount;

        public viewholder(View itemView)
        {
            super(itemView);
            description = itemView.findViewById(R.id.editText4);
            date = itemView.findViewById(R.id.editText5);
            amount = itemView.findViewById(R.id.editText6);

        }

    }

}
