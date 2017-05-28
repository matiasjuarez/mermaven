package navigation;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by matias on 27/05/17.
 */
public class Frame {
    private String frameName;
    private String xpath;
    private Frame parent;
    private ArrayList<Frame> children;

    public Frame(String frameName, String xpath){
        this.children = new ArrayList<>();
        this.frameName = frameName;
        this.xpath = xpath;
    }

    public Frame getParent() {
        return parent;
    }

    public void setParent(Frame parent) {
        this.parent = parent;

        if(!parent.childExists(this)){
            parent.addChild(this);
        }
    }

    public String getFrameName() {
        return frameName;
    }

    public String getXpath() {
        return xpath;
    }

    public void addChild(Frame frame){
        if(childExists(frame)){
            return;
        }

        children.add(frame);
        frame.setParent(this);
    }

    public boolean childExists(Frame frame){
        for(Frame childFrame : children){
            if(childFrame.getFrameName().equalsIgnoreCase(frame.getFrameName())){
                return true;
            }
        }

        return false;
    }

    /**
     * Search a direct child of this frame by name
     * @param name - The name of the Frame we want
     * @return the child Frame
     */
    public Frame getChildFrame(String name){
        for(Frame frame : children){
            if(frame.getFrameName().equalsIgnoreCase(name)){
                return frame;
            }
        }

        return null;
    }

    /**
     * It looks for a descendant of this frame. It doesn't care about the level.
     * @param name - The name of the frame we want.
     * @return the descendant frame if it exists or null
     */
    public Frame getDescendentFrame(String name){
        Frame wantedFrame = null;

        // We first try to get a child frame with the name sent as parameter
        wantedFrame = getChildFrame(name);

        // If we can't find anything, we ask the children of this Frame if they
        // have a child with the name we are looking for
        if(wantedFrame == null) {
            for(Frame childFrame : children){
                wantedFrame = childFrame.getDescendentFrame(name);
                if(wantedFrame != null){
                    break;
                }
            }
        }

        return wantedFrame;
    }

    /**
     * Gets all the ascendants of this frame
     * @return an ArrayList with all the ascendants of this frame in the order they should be
     * navigated to get to this frame
     */
    public ArrayList<Frame> getAllAscendants() {
        ArrayList<Frame> ascendants = new ArrayList<>();

        Frame nextAscendant = this.getParent();

        while(nextAscendant != null) {
            ascendants.add(nextAscendant);
            nextAscendant = nextAscendant.getParent();
        }

        Collections.reverse(ascendants);
        return ascendants;
    }
}
