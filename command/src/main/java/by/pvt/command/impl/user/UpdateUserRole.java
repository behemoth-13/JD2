package by.pvt.command.impl.user;

import by.pvt.bean.constants.Roles;
import by.pvt.command.AttributeNames;
import by.pvt.command.PageNames;
import by.pvt.command.ParameterNames;
import by.pvt.command.impl.Command;
import by.pvt.exception.OperationNotExecutedException;
import by.pvt.service.UserService;
import by.pvt.service.factory.ServiceName;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Alex on 28.03.2017.
 */
public class UpdateUserRole extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        UserService service = (UserService) serviceFactory.getOperationService(ServiceName.USER_SERVICE);

        Integer role = (Integer) session.getAttribute(AttributeNames.ROLE);
        if (role != Roles.ADMIN.getCodeRole()) {
            request.setAttribute(AttributeNames.EXCEPTION, "Wrong Access level");
            return PageNames.EXCEPTION;
        }
        try {
            int userId = Integer.parseInt(request.getParameter(ParameterNames.U_ID));
            int userRole = Integer.parseInt(request.getParameter(ParameterNames.U_ROLE));
            service.updateUserRole(userId, userRole);
            request.setAttribute(AttributeNames.MESSAGE, "Role successfully changed");
        } catch (OperationNotExecutedException | IllegalArgumentException e) {
            request.setAttribute(AttributeNames.EXCEPTION, e.getMessage());
            return PageNames.EXCEPTION;
        }
        return PageNames.SUCCESS;
    }
}
