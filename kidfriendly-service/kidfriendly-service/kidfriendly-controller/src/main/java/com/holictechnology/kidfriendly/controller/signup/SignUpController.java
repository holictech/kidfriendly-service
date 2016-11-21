package com.holictechnology.kidfriendly.controller.signup;


import javax.ejb.Stateless;
import javax.ws.rs.Path;

import com.holictechnology.kidfriendly.controller.AbstractController;


@Stateless
@Path(value = "/signup")
public class SignUpController extends AbstractController {

    private static final long serialVersionUID = -5979491621431001183L;

//    @EJB
//    private UserLocal userLocal;
//
//    @POST
//    @Path(value = "/register-user")
//    @Consumes(MediaType.MULTIPART_FORM_DATA)
//    @Produces(value = MediaType.APPLICATION_JSON)
//    public Response register(@MultipartForm UserDto userDto) {
//        try {
//            User user = new User();
//            user.setDesName(userDto.getDesName());
//            user.setImgUser(((userDto.getImgUser() != null
//                    && userDto.getImgUser().length == BigInteger.ZERO.intValue()) ? null : userDto.getImgUser()));
//            user.setLogin(new Login());
//            user.getLogin().setIdLogin(userDto.getIdLogin());
//            user.getLogin().setDesPassword(userDto.getToken());
//            user.getLogin().setStActive(Boolean.TRUE);
//            user.getLogin().setUser(user);
//            userLocal.save(user);
//        } catch (Exception e) {
//            createLogger(this.getClass()).error(e.getMessage());
//        }
//
//        return createResponse(null);
//    }
//
//    @POST
//    @Path(value = "/register-company")
//    @Produces(value = MediaType.APPLICATION_JSON)
//    public Response register() {
//        return createResponse(null);
//    }
}
