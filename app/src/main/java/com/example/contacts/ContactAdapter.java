package com.example.contacts;

import android.content.ContentValues;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    private ArrayList<Contact> mContacts;
    private Context mContext;
    private LayoutInflater mInflater;

    public ContactAdapter(ArrayList<Contact> mContacts, Context mContext) {
        this.mContacts = mContacts;
        this.mContext = mContext;
        this.mInflater = LayoutInflater.from(mContext);
    }

    public ContactAdapter(MainActivity mainActivity, int simple_list_item_1, ArrayList<String> listContacts) {
    }

    public ContactAdapter(ArrayList<String> listContacts, MainActivity mContext) {
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = mInflater.inflate(R.layout.item_list_contact,
                viewGroup, false);
        return new ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ContactAdapter.ContactViewHolder holder, int i) {
        Contact contact = mContacts.get(i);
        //holder.ivAvatar.setText(contact.getmTitle());
        holder.tvFullname.setText(contact.getmFullname());
        //holder.ivCall.setText(contact.getmCompany());
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder{
        ImageView ivAvatar;
        TextView tvFullname;
        ImageView ivCall;

        public ContactViewHolder(View itemView){
            super(itemView);
            itemView.setClickable(true);
            ivAvatar = (ImageView) itemView.findViewById(R.id.iv_avatar);
            tvFullname = (TextView) itemView.findViewById(R.id.tv_fullname);
            ivCall = (ImageView) itemView.findViewById(R.id.iv_call);
        }
    }
}