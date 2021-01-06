import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("3b381bec-3593-436e-a3ec-4d2b4fef8925")
public interface IView {
    @objid ("659f298b-1782-43cc-a41d-85b1cc666206")
    Controller getController();

    @objid ("a8e5a090-682e-4bcd-b061-033d7ef0393c")
    void setController(Controller value);

}
