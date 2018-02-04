package gtm.com.calculator.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.util.Linkify
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import gtm.com.calculator.R
import gtm.com.calculator.adapter.MultiplicationAdapter


/**
 * @author Gowtham kumar Paidi Muddhala R
 *
 *  Main screen
 */
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mEdMulipliedNum = findViewById<EditText>(R.id.id_ed_multiplied_num);
        val mBtnMultiply = findViewById<Button>(R.id.id_btn_multiply);
        val mRcvMultiplicationTable = findViewById<RecyclerView>(R.id.recyclerView) as RecyclerView;
        val mTvAuthorName = findViewById<TextView>(R.id.id_tv_author_name);
        Linkify.addLinks(mTvAuthorName, Linkify.WEB_URLS);

        mBtnMultiply.setOnClickListener({
            val adapter = MultiplicationAdapter(mEdMulipliedNum.text.toString());
            mRcvMultiplicationTable.adapter = adapter;
            mRcvMultiplicationTable.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            val imm = this.getSystemService(android.content.Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(mRcvMultiplicationTable.windowToken, 0)
        })
    }
}
