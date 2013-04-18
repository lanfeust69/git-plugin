package hudson.plugins.git;

import hudson.Extension;
import hudson.model.AbstractDescribableImpl;
import hudson.model.Descriptor;
import org.kohsuke.stapler.DataBoundConstructor;

import java.io.Serializable;

public class UserMergeOptions extends AbstractDescribableImpl<UserMergeOptions>  implements Serializable {

    private String mergeRemote;
    private String mergeTarget;
    private boolean rebase;

    @DataBoundConstructor
    public UserMergeOptions(String mergeRemote, String mergeTarget, boolean rebase) {
        this.mergeRemote = mergeRemote;
        this.mergeTarget = mergeTarget;
        this.rebase = rebase;
    }

    public String getMergeRemote() {
        return mergeRemote;
    }

    public String getMergeTarget() {
        return mergeTarget;
    }

    public boolean getRebase() {
        return rebase;
    }

    @Extension
    public static class DescriptorImpl extends Descriptor<UserMergeOptions> {
        @Override
        public String getDisplayName() {
            return "";
        }
    }
}
