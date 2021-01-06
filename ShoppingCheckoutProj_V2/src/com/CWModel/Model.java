import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("d7185f15-e189-4753-9ea8-d04e732ddc47")
public class Model implements IModelSubject {
    @objid ("fcbe321e-3459-4c1b-b8a5-57bfcb7b82ee")
    public List<IModelObserver> iModelObserver = new ArrayList<IModelObserver> ();

}
