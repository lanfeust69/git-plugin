package hudson.plugins.git.opt;

import org.eclipse.jgit.transport.RemoteConfig;
import org.kohsuke.stapler.export.Exported;
import org.kohsuke.stapler.export.ExportedBean;

import java.io.Serializable;

/**
 * Git SCM can optionally perform a merge with another branch (possibly another repository.)
 *
 * This object specifies that configuration.
 */
@ExportedBean(defaultVisibility = 999)
public class PreBuildMergeOptions implements Serializable {
    private static final long serialVersionUID = 2L;

    /**
     * Remote repository that contains the {@linkplain #mergeTarget ref}.
     */
    public RemoteConfig mergeRemote = null;

    /**
     * Remote ref to merge.
     */
    public String mergeTarget = null;

    /**
     * Should we merge into target, or rebase on target.
     */
    public boolean rebase = false;

    @Exported
    public RemoteConfig getMergeRemote() {
        return mergeRemote;
    }

    public void setMergeRemote(RemoteConfig mergeRemote) {
        this.mergeRemote = mergeRemote;
    }

    @Exported
    public String getMergeTarget() {
        return mergeTarget;
    }

    public void setMergeTarget(String mergeTarget) {
        this.mergeTarget = mergeTarget;
    }

    @Exported
    public boolean getRebase() {
        return rebase;
    }

    public void setRebase(boolean rebase) {
        this.rebase = rebase;
    }

    @Exported
    public String getRemoteBranchName() {
        return (mergeRemote == null) ? null : mergeRemote.getName() + "/" + mergeTarget;
    }

    public boolean doMerge() {
        return mergeTarget != null;
    }
}
