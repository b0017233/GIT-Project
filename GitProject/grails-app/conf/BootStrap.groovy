import gitproject.Placements
import gitproject.Student
import gitproject.Status
import gitproject.Application   

class BootStrap {

    def init = { servletContext ->
    def firststudent = new Student(name:"Fred", coursecode:"3", notes:"none", applications:"none").save();
    def secondplace = new Placements(jobtitle:"Operator", application:"none", companyname:"the company", status:"1").save();
    def onestatus = new Status(code:"1", description:"completed").save();
    }
    def destroy = {
    }
}
