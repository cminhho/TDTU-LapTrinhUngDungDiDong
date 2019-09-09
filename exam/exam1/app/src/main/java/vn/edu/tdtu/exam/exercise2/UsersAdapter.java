package vn.edu.tdtu.exam.exercise2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.admin.exam.R;
import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {

  private List<User> users;

  public UsersAdapter(List<User> users) {
    this.users = users;
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView txtUsername, txtEmail;

    public ViewHolder(View view) {
      super(view);
      txtUsername = view.findViewById(R.id.txt_username);
      txtEmail = view.findViewById(R.id.txt_email);
    }
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.user_list_row, parent, false);

    return new ViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    User user = users.get(position);
    holder.txtUsername.setText(user.getUsername());
    holder.txtEmail.setText(user.getEmail());
  }

  @Override
  public int getItemCount() {
    return users.size();
  }

}