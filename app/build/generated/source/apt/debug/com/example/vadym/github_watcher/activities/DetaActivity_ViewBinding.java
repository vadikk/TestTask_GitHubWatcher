// Generated code from Butter Knife. Do not modify!
package com.example.vadym.github_watcher.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.vadym.github_watcher.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DetaActivity_ViewBinding implements Unbinder {
  private DetaActivity target;

  @UiThread
  public DetaActivity_ViewBinding(DetaActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DetaActivity_ViewBinding(DetaActivity target, View source) {
    this.target = target;

    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerDetail, "field 'recyclerView'", RecyclerView.class);
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.progressBar, "field 'progressBar'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DetaActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerView = null;
    target.progressBar = null;
  }
}
