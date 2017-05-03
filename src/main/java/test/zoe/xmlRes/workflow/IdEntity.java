package test.zoe.xmlRes.workflow;

import java.io.Serializable;

/**
 * 统一定义id的entity基类.
 *
 * @author Wticher
 */
public abstract class IdEntity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 3299522232254196582L;
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
