package web.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import web.service.LoginService;
import web.service.MathQuestionService;

@Controller
@RequestMapping("/")
public class RoutingServlet {

    // GET mappings
    @GetMapping("/")
    public String welcome() {
        System.out.println("Welcome ...");
        return "view-welcome";
    }

    @GetMapping("/login")
    public String loginView() {
        System.out.println("login view...");
        return "view-login";
    }

    @GetMapping("/q1")
    public String q1View() {
        System.out.println("q1 view...");
        return "view-q1";
    }

    @GetMapping("/q2")
    public String q2View() {
        System.out.println("q2 view...");
        return "view-q2";
    }

    @GetMapping("/q3")
    public String q3View() {
        System.out.println("q3 view...");
        return "view-q3";
    }

    // POST mappings
    @PostMapping("/login")
    public RedirectView login(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String dob = request.getParameter("dob");
        
        if (LoginService.login(username, password, dob)) {
            return new RedirectView("/q1", true);
        } else {
            redirectAttributes.addFlashAttribute("message", "Incorrect credentials.");
            return new RedirectView("/login", true);
        }
    }

    @PostMapping("/q1")
    public RedirectView q1(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");
        String resultUser = request.getParameter("result");
        
        double calculatedResult = MathQuestionService.q1Addition(number1, number2);
        
        if (calculatedResult == Double.parseDouble(resultUser)) {
            return new RedirectView("/q2", true);
        } else {
            redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
            return new RedirectView("/q1", true);
        }
    }

    @PostMapping("/q2")
    public RedirectView q2(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");
        String resultUser = request.getParameter("result");
        
        double calculatedResult = MathQuestionService.q2Subtraction(number1, number2);
        
        if (calculatedResult == Double.parseDouble(resultUser)) {
            return new RedirectView("/q3", true);
        } else {
            redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
            return new RedirectView("/q2", true);
        }
    }

    @PostMapping("/q3")
    public RedirectView q3(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        // Retrieve input parameters from the request
        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");
        String resultUser = request.getParameter("result");
        
        // Calculate the result of the third math question
        double calculatedResult = MathQuestionService.q3Multiplication(number1, number2);
        
        // Check if the user's answer matches the calculated result
        if (Double.parseDouble(resultUser) == calculatedResult) {
            // If the answer is correct, redirect to a success page or the next question
            return new RedirectView("/success", true);
        } else {
            // If the answer is incorrect, redirect back to the same question with an error message
            redirectAttributes.addFlashAttribute("message", "Incorrect answer, please try again.");
            return new RedirectView("/q3", true);
        }
    }

