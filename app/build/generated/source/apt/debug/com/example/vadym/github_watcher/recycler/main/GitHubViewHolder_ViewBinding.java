// Generated code from Butter Knife. Do not modify!
package com.example.vadym.github_watcher.recycler.main;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.vadym.github_watcher.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class GitHubViewHolder_ViewBinding implements Unbinder {
  private GitHubViewHolder target;

  @UiThread
  public GitHubViewHolder_ViewBinding(GitHubViewHolder target, View source) {
    this.target = target;

    target.avatar = Utils.findRequiredViewAsType(source, R.id.imageAvatar, "field 'avatar'", ImageView.class);
    target.name = Utils.findRequiredViewAsType(source, R.id.nameRepository, "field 'name'", TextView.class);
    target.description = Utils.findRequiredViewAsType(source, R.id.description, "field 'description'", TextView.class);
    target.forkCount = Utils.findRequiredViewAsType(source, R.id.forkCount, "field 'forkCount'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    GitHubViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.avatar = null;
    target.name = null;
    target.description = null;
    target.forkCount = null;
  }
}
