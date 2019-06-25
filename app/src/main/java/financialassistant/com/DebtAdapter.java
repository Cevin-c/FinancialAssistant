package financialassistant.com;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DebtAdapter extends

        RecyclerView.Adapter<DebtAdapter.viewholder>

{

    List<Debtclass> debtclassArrayList = new ArrayList<>();
    Context mContext;

    public DebtAdapter(Context context) {
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
        Debtclass debtclass = debtclassArrayList.get(position);

        holder.description.setText(debtclass.getdescription());
        holder.duedate.setText(debtclass.getduedate());
        holder.dateborrowed.setText(debtclass.getdateborrowed());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setDebtclassArrayList(List<Debtclass> debtclassArrayList) {
        this.debtclassArrayList = debtclassArrayList;
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
