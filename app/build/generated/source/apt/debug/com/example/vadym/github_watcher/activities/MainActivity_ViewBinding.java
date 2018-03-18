// Generated code from Butter Knife. Do not modify!
package com.example.vadym.github_watcher.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.vadym.github_watcher.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(MainActivity target, View source) {
    this.target = target;

    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recycler, "field 'recyclerView'", RecyclerView.class);
    target.searchView = Utils.findRequiredViewAsType(source, R.id.search, "field 'searchView'", SearchView.class);
    target.bar = Utils.findRequiredViewAsType(source, R.id.progressBar, "field 'bar'", ProgressBar.class);
    target.cardView = Utils.findRequiredViewAsType(source, R.id.errorCardView, "field 'cardView'", CardView.class);
    target.errorText = Utils.findRequiredViewAsType(source, R.id.errorText, "field 'errorText'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerView = null;
    target.searchView = null;
    target.bar = null;
    target.cardView = null;
    target.errorText = null;
  }
}
