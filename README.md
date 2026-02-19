# COMP3170 – Week 1 practical task

## Topics Covered
* Introduction to OpenGL
* Setting up Eclipse with LWJGL
* Introduction to graphics programming

## What is OpenGL?
OpenGL has been described as “an engine for drawing triangles very fast”. As a low-level graphics API, it contains very little built-in support for achieving particular graphics effects like lighting, shadows, or even 3D. It is designed to provide an interface for programming your own effects on the GPU. The disadvantage of this is there is no simple “turn on lighting” API call. The advantage, however, is that you’re not stuck with one default lighting model, you can program lights to work however you want, to add extra layers of realism or to achieve weird effects of your own.

### LWJGL
Lightweight Java Game Library (LWJGL) is a Java library which includes a wrapper that allows graphics development with OpenGL in Java. You are not expected to memorise the OpenGL function calls. Instead, we will provide you with a Java framework to avoid you having to deal with the more unpleasant parts of working with wrappers and focus on writing interesting graphics effects in shaders.

We will be using LWJGL 3.4.0 for this unit. Installing it can be tricky, so we have set up an Eclipse project containing all the necessary files to run LWJGL on either a Mac or Windows PC. However, if you want more information on LWJGL, we recommend checking out the [website](https://www.lwjgl.org/).


## Clone the comp3170-lwjgl project
Follow this link to the Github repo of the project:
https://github.com/COMP3170/comp3170-lwjgl

Clone the project onto your machine using Github Desktop. You can store the project anywhere you want, but make sure the name of the repo is **comp3170-lwjgl**. If you are using the lab computers, we recommend you save it to the H drive to prevent needing to repeat the process every time you move computers (Note: this is the only time the MQGames team will ever recommend you save anything to the H drive). 
 
Open Eclipse. If you don’t have a workspace, you will be prompted to create one. Give it a meaningful name, like “COMP3170” or “Graphics Programming”.

You now want to add the repo to your Eclipse workspace.  Select <b>File > Import...</b> from the menu.

Select "Existing Projects into Workspace".

![Begining the import process by selecting "Existing Projects into Workspace" from the menu](images/selectingproject.png)
 
You will now be prompted to select the root directory where you cloned the project. Press <b>Browse…</b> and then select the appropriate folder. It is good practice to keep all your projects in the one folder so you can use the same root directory. 

If all goes well, the Projects list should populate with your Eclipse projects, including `comp3170-lwjgl`. Make sure the checkbox is ticked next to the lwjgl project, and press </b>Finish</b> to begin import.

![Confirming import by making sure the relevant projects have their tickbox checked](images/importproject.png)
 
This will add the project your Eclipse workspace. If you have a look inside the project in the Package Explorer, you should see a number of LWJGL and JOML libraries.

![The package explorer view in Eclipse](images/packageexplorer.png)

### Check for updates!
Throughout semester, we will occasionally be updating this library. We will announce when we make updates, but it is always a good idea to fetch and pull the latest version of the repo just in case.

## Check out the demo code & set the classpath
Today, you will examine and modify some graphics code (both java and shader) to get familiar with graphics programming. Like any discipline, graphics programming requires its own approach to programming and thinking about problems.

If you haven't already, clone this repo onto your computer. Then, follow the same steps to import the project into your Eclipse workspace.

Open the `Week1.java` file. The project does not know where to find your LWJGL libraries, so you should see a bunch of errors in the <b>Problems</b> panel:

![Errors in the "problems" panel](images/problems.png)
 
You need to add the comp3170-lwjgl project to the classpath. From the menu select <b>Project > Properties</b> to open the properties window. Select <b>Java Build Path > Projects</b>. You should see something like this:

![The Java Build Path window](images/selectingclasspath.png)
 
Click on <b>Classpath</b> and press the <b>Add…</b> button. <b>Select</b> the comp3170-lwjgl project from the list. Press <b>OK</b> and <b>Apply and Close</b>.
 
Check the Problems panel again to make sure all the errors have been fixed.

In future pracs, this project should already be included in the Classpath. However, this is one of the first things to check if you are getting errors about not being able to find LWJGL classes or methods.

### Commit and push your changes
Remember to practice good version control. Always commit and push changes incrementally. This is a third year unit, and no sympathy will be given for students forgetting to back-up their work.

### Assigning a JDK
LWJGL is a fairly well-maintained library, and works with any Java Runtime Environment above JDK 8. For this unit, we will be using JDK 17.0.5, as we know it works well with LWJGL. We will briefly cover how to ensure your lab computer is correctly configured before running any code.

---
<center><b>Working on your own device?</b> </center>

If you are working on your own device, you may want to check out the <b>COMP3170 On Your Own Computer</b> document on iLearn for more info on how to set-up Eclipse.

---

We want to make sure our workspace default JRE is set to JDK 17.0.6 (the abbreviations can be confusing). To do so, select <b>Window > Preferences</b> in Eclipse. On Mac, select <b>Eclipse > Preferences</b>.

From the directory on the right, select <b>Java</b> and the <b>Installed JREs</b> submenu. In the lab computers, you should see only one option, which is labelled "JRE". Check the directory path to see that this points to jdk-17.0.6. Your home set-up may have these labelled differently. If all is well, you can jump to "Run demo code & edit the shader".

If you can't see JDK 17.0.6 (or a JRE by another name that points to it), make sure it is installed, then return to this screen and press <b>Add…</b>. Select <b>Standard VM</b> and click <b>Next</b>.

![Adding a JRE by selecting "Standard VM" from the list.](images/addajre.png)

Next to JRE home will be a <b>Directory…</b> button. Click on this and then find the folder with JDK 17.0.5 in it and click Open. If you are on the lab computers, this should just be C: > Program Files > Java > jdk-17.0.5. If all goes well, you should now see something like this:

![Defining a JRE by locating it on your computer and then giving it a name.](images/defineajre.png)
 
You could technically enter anything you want into JRE name. I like to be specific as I often have multiple versions of Java on my machine and want to keep track of everything. Once you’re done, hit Finish, tick JDK 17.0.5, and then press <b>Apply</b> and <b>Close</b>.

Like we said, you can have multiple versions of Java at any one time, so we need to make sure that our projects are using the workplace default (which we just set). 

In the week1 project, have a look at the JRE System Library. To confirm or to change it, Right click on it and select Properties. 
 
Then, select JDK 17.0.6 by ticking Workspace Default JRE.

![Selecting the workspace default](images/workspacedefault.png)

 Press <b>Apply</b> and <b>Close</b>.

Important info for Mac users
---
Running LWJGL code on Mac requires adding the following argument to the JVM: `-XstartOnFirstThread`.

In Eclipse, this can be done in <b>Run > Run configurations > Arguments > VM arguments.</b>

If you encounter problems getting your code to run after this, speak to your tutor or consult the <b>COMP3170 On Your Computer</b> document on iLearn for workarounds and solutions. 

---

## Checking out the demo code

In the package explorer, find Week1.java. Select <b>Run > Run as … > Java Application</b>.

If all goes well, you should now see a triangle that changes from black to purple vertically:

![A triangle going from black to purple.](images/grimtriangle.png)

Your task today is to analyse this code to better understand how a graphics application generally works. Working with others and guided by your instructor, answer the following questions - you'll want to leave comments in the code as you go so you can check back on this later:

### Project structure
* There are four files in this project: `Scene.java`, `Week1.java`, `fragment.glsl` and `vertex.glsl`. What is the purpose of each of them? How might this change in a bigger project?

### Creating an app
* This app renders a window on screen of certain dimensions and with a particular size. Where in the code is this set?

* Resizing the screen causes it to change shape. Where in the code does this happen?

### Drawing a scene
* Each frame, the triangle is drawn on screen with the same background colour. Which lines of code control this, and how?

* The triangle is drawn with particular dimensions. Where are these defined?

* The triangle is drawn with its vertices at particular points on screen. Where is this defined?

* The triangle is drawn a particular colour. How and where is this defined?

### Shaders
#### Vertex Shader
* The shaders used to draw the scene need to be pointed to and compiled. Where does this happen?

* The vertices used to create the triangle need to be passed into graphics memory. Where does this happen?

* The vertex shader is needed to control the size, shape and location of the triangle on screen. What data is passed through to achieve this, and where (both in Java and where it is received and used in GLSL)?

#### Fragment Shader
* The fragment shader determines what colour to make each pixel. Where does it get the data to make the triangle purple?

* The triangle is black at the bottom, and slowly becomes purple. This is happening in the fragment shader. Which line of code is altering the colour of the triangle? What additional properties are being used to do this?

Your instructor will guide you on sharing your findings. You should also mention any lines of code or functions you are still unsure about at this time.

## Making Changes
With the time remaining, put what you've learnt into action! Here are a few challenges:

Adjust the height of the triangle, but nothing else.
<p style="text-align:center"><img src="images/changeheight.png" width="50%" height="50%"></p>

Change the size of the screen on start-up.
<p style="text-align:center"><img src="images/changewindow.png" width="50%" height="50%"></p>

Change the background colour to something other than blue, and the triangle to something other than purple.
<p style="text-align:center"><img src="images/changecolours.png" width="50%" height="50%"></p>

Change the points of the triangle to make it into a right angle, obtuse, or other type of triangle.
<p style="text-align:center"><img src="images/changepoints.png" width="50%" height="50%"></p>

Change the triangle so its colour changes horizontally instead of vertically.
<p style="text-align:center"><img src="images/changedirection.png" width="50%" height="50%"></p>

Change the triangle so that the redness changes vertically, and the greenness changes horizontally (blue can be whatever you want).
<p style="text-align:center"><img src="images/finalboss.png" width="50%" height="50%"></p>


Anything else you can think of!

## Show-And-Tell Post
Make sure you save and push your work, but also take some screen captures of your triangles to share on the weekly iLearn show-and-tell post. See you next time!

## Syntax Highlighting
There is an Eclipse Shaders extension which does GLSL syntax highlighting available here:
https://sourceforge.net/projects/glshaders/.

Download and unzip Eclipse_shaders_1_0_2.zip.

Eclipse_shaders_1_0_2 should contain two folders: features and plugins.

In file explorer, navigate to <b>Eclipse > 'your Eclipse java version' > eclipse > dropins</b>. Place both the features and plugins folders here. Restart Eclipse.

To test it has installed correctly, select <b>Window > Preferences</b>. You should now see an option called “Shaders Preferences” and a sub-option “Shaders Editor Preferences”. You can modify the colours here to get your shader code looking how you like it (especially with your new understanding of colour from this week!).

![Assigning colour syntax to GLSL files](images/settingcolour.png)
 
Now, your .glsl files should automatically open with this editor. If they don’t, right click and selected <b>Open With… > GLSL Editor</b>.