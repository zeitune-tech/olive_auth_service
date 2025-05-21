package sn.zeitune.oliveinsuranceauthservice.app.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OtpService {

    private final MailService mailService;

    public String generateOtp() {
        return String.valueOf(new java.util.Random().nextInt(899999) + 100000);
    }

    public void sendOtp(String to, String otp) {
        String subject = "Votre code de vérification (OTP)";
        String body = String.format("""
                Bonjour,
                
                Votre code de vérification est : %s
                
                Ce code est valable pendant 5 minutes.
                
                Si vous n’êtes pas à l’origine de cette demande, veuillez ignorer ce message.
                
                Cordialement,
                L’équipe Zeitune
                """, otp);
        mailService.send(to, subject, body);
    }
}

