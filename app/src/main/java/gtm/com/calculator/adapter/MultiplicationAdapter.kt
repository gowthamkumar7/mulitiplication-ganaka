package gtm.com.calculator.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import gtm.com.calculator.R


/**
 * @author Gowtham kumar Paidi Mudddhala R
 *  Custom adapter for RecyclerView
 */


class MultiplicationAdapter(val multipliedNumber: String) : RecyclerView.Adapter<MultiplicationAdapter.MultiplicationViewHolder>() {


    override fun onBindViewHolder(holder: MultiplicationViewHolder, position: Int) {
        holder.multipliedNum.setText(multipliedNumber)
        holder.multiplicatedNum.setText((position + 1).toString());
        val result = multipliedNumber.toInt() * (position + 1);
        holder.multipliedResult.setText(result.toString())
    }

    override fun getItemCount(): Int {
        //Restricting only for 15 times
        return 15;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MultiplicationViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_multiplication_holder, parent, false);
        return MultiplicationViewHolder(itemView);

    }


    /**
     * Custom viewholder
     */
    inner class MultiplicationViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        var multipliedNum: TextView = itemview.findViewById(R.id.id_tv_multiplied_num);
        var multiplicatedNum: TextView = itemview.findViewById(R.id.id_tv_multiplication_num);
        var multipliedResult: TextView = itemview.findViewById(R.id.id_tv_multiplication_result);

    }

}