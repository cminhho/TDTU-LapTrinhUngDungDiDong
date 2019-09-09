package vn.edu.tdtu.exam.exercise2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.admin.exam.R;
import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {

  private List<User> users;

  public UsersAdapter(List<User> users) {
    this.users = users;
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    private final Button btnActivate;
    private TextView txtUsername, txtEmail;

    private ViewHolder(View view) {
      super(view);
      txtUsername = view.findViewById(R.id.txt_username);
      txtEmail = view.findViewById(R.id.txt_email);
      btnActivate = view.findViewById(R.id.btn_activate);
    }
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.user_list_row, parent, false);

    return new ViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, final int position) {
    final User user = users.get(position);
    holder.txtUsername.setText(user.getUsername());
    holder.txtEmail.setText(user.getEmail());
    Boolean favorite = user.isActivated();
    setActivateState(favorite, holder);

    holder.btnActivate.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
        User user = users.get(position);
        boolean favorite = !user.isActivated();
        setActivateState(favorite, holder);
        user.setActivated(favorite);
        notifyDataSetChanged();
      }
    });
  }

  private void setActivateState(Boolean favorite, ViewHolder holder) {
    if(favorite){
      holder.btnActivate.setText("Activated");
    } else {
      holder.btnActivate.setText("Unactivated");
    }
  }

  @Override
  public int getItemCount() {
    return users.size();
  }

}