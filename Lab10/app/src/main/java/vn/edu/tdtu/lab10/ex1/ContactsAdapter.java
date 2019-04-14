package vn.edu.tdtu.lab10.ex1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import vn.edu.tdtu.lab10.R;

/**
 * Created by thChung on 4/13/2019.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.MyViewHolder> {

        private List<Contact> contactsList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView name, phoneNumber, status;

            public MyViewHolder(View view) {
                super(view);
                name = (TextView) view.findViewById(R.id.name);
                phoneNumber = (TextView) view.findViewById(R.id.phoneNumber);
                status = (TextView) view.findViewById(R.id.status);
            }
        }

        public ContactsAdapter(List<Contact> contactsList) {
            this.contactsList = contactsList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.contact_list_row, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            Contact contact = contactsList.get(position);
            holder.name.setText(contact.getName());
            holder.phoneNumber.setText(contact.getPhoneNumber());
            holder.status.setText("Active");
        }

        @Override
        public int getItemCount() {
            return contactsList.size();
        }
    }