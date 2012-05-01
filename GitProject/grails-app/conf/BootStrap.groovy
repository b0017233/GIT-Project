import gitproject.Placements
import gitproject.Student
import gitproject.Status
import gitproject.Application   

class BootStrap {

    def init = { servletContext ->
    def fredplace = new Placements(name:"Fred", coursecode:"3").save();
    def joeplace = new Placements(name:"Joe", coursecode:"4").save();
    def onestatus = new Status(code:"1", description:"completed").save();
    }
    def destroy = {
    }
}
