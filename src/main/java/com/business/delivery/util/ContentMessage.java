package com.business.delivery.util;

public class ContentMessage {

    public static String verifyHTML(String nomDest,String verifyURL){
        String contenido="<!DOCTYPE html><html><head> <title></title> <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"/> <style type=\"text/css\"> @media screen{@font-face{font-family: 'Lato'; font-style: normal; font-weight: 400; src: local('Lato Regular'), local('Lato-Regular'), url(https://fonts.gstatic.com/s/lato/v11/qIIYRU-oROkIk8vfvxw6QvesZW2xOQ-xsNqO47m55DA.woff) format('woff');}@font-face{font-family: 'Lato'; font-style: normal; font-weight: 700; src: local('Lato Bold'), local('Lato-Bold'), url(https://fonts.gstatic.com/s/lato/v11/qdgUG4U09HnJwhYI-uK18wLUuEpTyoUstqEm5AMlJo4.woff) format('woff');}@font-face{font-family: 'Lato'; font-style: italic; font-weight: 400; src: local('Lato Italic'), local('Lato-Italic'), url(https://fonts.gstatic.com/s/lato/v11/RYyZNoeFgb0l7W3Vu1aSWOvvDin1pK8aKteLpeZ5c0A.woff) format('woff');}@font-face{font-family: 'Lato'; font-style: italic; font-weight: 700; src: local('Lato Bold Italic'), local('Lato-BoldItalic'), url(https://fonts.gstatic.com/s/lato/v11/HkF_qI1x_noxlxhrhMQYELO3LdcAZYWl9Si6vvxL-qU.woff) format('woff');}}/* CLIENT-SPECIFIC STYLES */ body, table, td, a{-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%;}table, td{mso-table-lspace: 0pt; mso-table-rspace: 0pt;}img{-ms-interpolation-mode: bicubic;}/* RESET STYLES */ img{border: 0; height: auto; line-height: 100%; outline: none; text-decoration: none;}table{border-collapse: collapse !important;}body{height: 100% !important; margin: 0 !important; padding: 0 !important; width: 100% !important;}/* iOS BLUE LINKS */ a[x-apple-data-detectors]{color: inherit !important; text-decoration: none !important; font-size: inherit !important; font-family: inherit !important; font-weight: inherit !important; line-height: inherit !important;}/* MOBILE STYLES */ @media screen and (max-width:600px){h1{font-size: 32px !important; line-height: 32px !important;}}/* ANDROID CENTER FIX */ div[style*=\"margin: 16px 0;\"]{margin: 0 !important;}</style></head><body style=\"background-color: #e5e5e5; margin: 0 !important; padding: 0 !important;\"> <div style=\"display: none; font-size: 1px; color: #fefefe; line-height: 1px; font-family: 'Lato', Helvetica, Arial, sans-serif; max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden;\"> We're thrilled to have you here! Get ready to dive into your new account. </div><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"> <tr> <td bgcolor=\"#bf0e09\" align=\"center\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\"> <tr> <td align=\"center\" valign=\"top\" style=\"padding: 40px 10px 40px 10px;\"> </td></tr></table> </td></tr><tr> <td bgcolor=\"#bf0e09\" align=\"center\" style=\"padding: 0px 10px 0px 10px;\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\"> <tr> <td bgcolor=\"#ffffff\" align=\"center\" valign=\"top\" style=\"padding: 40px 20px 20px 20px; border-radius: 4px 4px 0px 0px; color: #111111; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 48px; font-weight: 400; letter-spacing: 4px; line-height: 48px;\">"+
                "<h1 style=\"font-size: 48px; font-weight: 400; margin: 2;\">¡Bienvenido [[name]]!</h1>"+
                "<img src=\" https://img.icons8.com/clouds/100/000000/handshake.png\" width=\"125\" height=\"120\" style=\"display: block; border: 0px;\"/> </td></tr></table> </td></tr><tr> <td bgcolor=\"#e5e5e5\" align=\"center\" style=\"padding: 0px 10px 0px 10px;\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\"> <tr> <td bgcolor=\"#ffffff\" align=\"left\" style=\"padding: 20px 30px 40px 30px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;\"> <p style=\"margin: 0;\">Estamos emocionados de que comiences tus clases. Primero, necesitas confirmar tu cuenta. Simplemente presione el botón de abajo. </td></tr><tr> <td bgcolor=\"#ffffff\" align=\"left\"> <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"> <tr> <td bgcolor=\"#ffffff\" align=\"center\" style=\"padding: 20px 30px 60px 30px;\"> <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\"> <tr> <td align=\"center\" style=\"border-radius: 3px;\" bgcolor=\"#bf0e09\">"+
                "<a href=\"[[URL]]\" target=\"_self\" style=\"font-size: 20px; font-family: Helvetica, Arial, sans-serif; color: #ffffff; text-decoration: none; color: #ffffff; text-decoration: none; padding: 15px 25px; border-radius: 2px; border: 1px solid #bf0e09; display: inline-block;\">Confirmar Cuenta</a>"+
                "</td></tr></table> </td></tr></table> </td></tr><tr> <td bgcolor=\"#ffffff\" align=\"left\" style=\"padding: 0px 30px 20px 30px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;\"> <p style=\"margin: 0;\">Si tiene alguna pregunta, simplemente responda a este correo electrónico; estaremos atentos para darle un buen servicio</p></td></tr><tr> <td bgcolor=\"#ffffff\" align=\"left\" style=\"padding: 0px 30px 40px 30px; border-radius: 0px 0px 4px 4px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;\"> <p style=\"margin: 0;\">Atte,<br> Cevichería Las Gaviotas</p></td></tr></table> </td></tr></table></body></html>";

        contenido = contenido.replace("[[name]]", nomDest);
        contenido = contenido.replace("[[URL]]", verifyURL);

        return contenido;
    }

    public static String resPassHTML(String resetPassURL){
        String contenido = "<!doctype html><html lang=\"en-US\"><head> <meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\"/> <title>Reset Password Email Template</title> <meta name=\"description\" content=\"Reset Password Email Template.\"> <style type=\"text/css\"> a:hover{text-decoration: underline !important;}</style></head><body marginheight=\"0\" topmargin=\"0\" marginwidth=\"0\" style=\"margin: 0px; background-color: #f2f3f8;\" leftmargin=\"0\"> <table cellspacing=\"0\" border=\"0\" cellpadding=\"0\" width=\"100%\" bgcolor=\"#f2f3f8\" style=\"@import url(https://fonts.googleapis.com/css?family=Rubik:300,400,500,700|Open+Sans:300,400,600,700); font-family: 'Open Sans', sans-serif;\"> <tr> <td> <table style=\"background-color: #f2f3f8; max-width:670px; margin:0 auto;\" width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\"> <tr> <td style=\"height:80px;\">&nbsp;</td></tr><tr> <td style=\"text-align:center;\"> <a href=\"https://rakeshmandal.com\" title=\"logo\" target=\"_blank\"> <img width=\"150\" src=\"https://www.shareicon.net/data/256x256/2016/06/26/623145_open_256x256.png\" title=\"password\" alt=\"logo\"> </a> </td></tr><tr> <td style=\"height:20px;\">&nbsp;</td></tr><tr> <td> <table width=\"95%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"max-width:670px;background:#fff; border-radius:3px; text-align:center;-webkit-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);-moz-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);box-shadow:0 6px 18px 0 rgba(0,0,0,.06);\"> <tr> <td style=\"height:40px;\">&nbsp;</td></tr><tr> <td style=\"padding:0 35px;\"> <h1 style=\"color:#1e1e2d; font-weight:500; margin:0;font-size:32px;font-family:'Rubik',sans-serif;\">Ha solicitado restablecer su contraseña</h1> <span style=\"display:inline-block; vertical-align:middle; margin:29px 0 26px; border-bottom:1px solid #cecece; width:100px;\"></span> <p style=\"color:#455056; font-size:15px;line-height:24px; margin:0;\"> No podemos simplemente enviarle su antigua contraseña. Se ha generado para usted un enlace único para restablecer su contraseña. Para restablecer su contraseña, haga clic en el siguiente enlace y siga las instrucciones. </p>" +
                "<a href=\"[[URL]]\" style=\"background:#bf0e09;text-decoration:none !important; font-weight:500; margin-top:35px; color:#fff;text-transform:uppercase; font-size:14px;padding:10px 24px;display:inline-block;border-radius:50px;\">RESTABLECER LA CONTRASEÑA</a> " +
                "</td></tr><tr> <td style=\"height:40px;\">&nbsp;</td></tr></table> </td><tr> <td style=\"height:20px;\">&nbsp;</td></tr><tr> <td style=\"text-align:center;\"> <p style=\"font-size:14px; color:rgba(69, 80, 86, 0.7411764705882353); line-height:18px; margin:0 0 0;\">&copy; <strong>aprendeconrysoft.com</strong></p></td></tr><tr> <td style=\"height:80px;\">&nbsp;</td></tr></table> </td></tr></table> </body></html>";

        contenido = contenido.replace("[[URL]]", resetPassURL);

        return contenido;
    }

}
