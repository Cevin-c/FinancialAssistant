package financialassistant.com;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ExpenseAdapter extends

        RecyclerView.Adapter<ExpenseAdapter.viewholder>

{

    List<Expenseclass> expenseclassArrayList = new ArrayList<>();
    Context mContext;

    public ExpenseAdapter(Context context) {
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
        Expenseclass expenseclass = expenseclassArrayList.get(position);

        holder.description.setText(expenseclass.getDescription_edittext());
        holder.period.setText(expenseclass.getperiod());
        holder.amount.setText(expenseclass.getAmount());
    }

    @Override
    public int getItemCount() {
        return expenseclassArrayList.size();
    }

    public void setExpenseclassArrayList(List<Expenseclass> expenseclassArrayList) {
        this.expenseclassArrayList = expenseclassArrayList;
        notifyDataSetChanged();
    }

    class viewholder extends RecyclerView.ViewHolder{
        TextView description;
        TextView period;
        TextView amount;

        public viewholder(View itemView) {
            super(itemView);
            description = itemView.findViewById(R.id.editText4);
            period = itemView.findViewById(R.id.editText5);
            amount = itemView.findViewById(R.id.editText6);

        }

    }

}
