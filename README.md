## JVoxelizer
### Project Status	
<a href="https://teamcity.ldtteam.com/viewType.html?buildTypeId=LetSDevTogether_JVoxelizer_Release_Release&guest=1">
<img src="https://img.shields.io/teamcity/http/teamcity.ldtteam.com/s/LetSDevTogether_JVoxelizer_Release_Release.svg?label=Release"/>
</a>
<a href="https://teamcity.ldtteam.com/viewType.html?buildTypeId=LetSDevTogether_JVoxelizer_Beta_Release&guest=1">
<img src="https://img.shields.io/teamcity/http/teamcity.ldtteam.com/s/LetSDevTogether_JVoxelizer_Beta_Release.svg?label=Beta"/>
</a>
<a href="https://teamcity.ldtteam.com/viewType.html?buildTypeId=LetSDevTogether_JVoxelizer_Alpha_Release&guest=1">
<img src="https://img.shields.io/teamcity/http/teamcity.ldtteam.com/s/LetSDevTogether_JVoxelizer_Alpha_Release.svg?label=Alpha"/>
</a>

### What is JVoxelizer? A wall between you and Minecraft.
JVoxelizers primary function is to reduce the time and effort it takes to update Minecraft mods between version.
It does this, by providing a common interface layer between Minecraft and your Mod, while allowing you to have Minecraft Version specific code next to your JVoxelizer compatible code.
This MC Version specific code is needed, in part due to the fact that JVoxelizer is not meant to cover all of Minecraft, but also due to it not being a mod loader or modding library, like Forge (FML) and Fabric.
Also if you want to consume a mods library that is not JVoxelizer compatible you will need to consume a MC version specific library to make the binding.

### How does JVoxelizer work? All the magic wrapped up in a nice bow.
JVoxelizer splits your mod up into 2 distinct areas of code.
- Your JVoxelizer based code (which depends solely on the JVoxelizer api, and some Minecraft libraries (like netty, or guava))
- Your Minecraft mod code (Currently only Forge Compatible)
When you distribute your code, you will need to shade JVoxelizer (in the MC Specific version) as well as your JVoxelizer based code into your Minecraft mod code jar.
The Minecraft mod code is commonly called the launcher, since it will take in the input from your Modloader, Minecraft and other mods and load your JVoxelizer based compatible mod, as well as the environment it runs in.

#### What is this environment? Providers and such...
Well the environment is the implementation of the JVoxelizer api that your JVoxelizer based code runs in.
As stated before your JVoxelizer based code should (in an ideal world) only depend on the JVoxelizer api and some Minecraft libraries.
So a valid question is: "How does my JVoxelizer based code interact with Minecraft or another mod?". 
This is where the Launcher comes into play. The launcher consumes the JVoxelizer implementation that is Minecraft version specific and initializes the environment by registering the relevant providers..
These providers are the equivalent of normal constructors in POJOs. They allow you to create instances of objects that the target interface represents in Minecraft.
An example would be:
```java
final ResourceLocation location = new ResourceLocation("modid:path"); //Minecraft based code
final IIdentifier location = IIdentifier.create("modid:path"); //JVoxelizer API based code
```
Hold on! Did you not just say that the providers create the instances? Then why do we call the `IIdentifier.create(String location)` method?
Well good that you ask. Providers are something that is regarded as internal to JVoxelizer.
A mod that uses JVoxelizer should in most cases not have to deal with providers.
To make it easy for a modder, JVoxelizer API classes which support instance creation, or for example represent an Enum value, have static methods that allow you 
either to create an instance or gain access to those enum entries.

### Features
Okey so now what does JVoxelizer actually support?
As of writing this page, it supports custom Guis, Containers, Items. But new features are added all the time, so keep an eye open.

#### What happens when a feature is missing entirely?
In that case please create an issue here on Github, adding entirely new features is easy and can be done pretty easily, but as this project is more 
of an community effort, we need to know what people use and as such what might be missing.

#### What happens if a feature is missing in a particular Minecraft Version or Platform?
Then in most cases an exception is thrown, or JVoxelizer will try to back-stuff this with its own logic.
This also means that when Minecraft changes a particular feature so much that we can not fit it in its original interface, we might need to change this.
This will however be announced in that case. 

### What about porting? Let's do this!
Okey when it comes to using and/or porting a mod to JVoxelizing, there are two ways todo this.
- Dynamic
- Straight.

#### Dynamic porting
With dynamic porting you add the Minecraft version specific dependency to your Mod. Do not forget to deobfuscate if required.
You can find a detailed tutorial [Here](https://github.com/ldtteam/JVoxelizer/wiki/Porting-a-mod-Dynamically-to-JVoxelizer).

#### Static porting
When you perform a static port, you do not use a rolling update.
Meaning from one update to the next your mod will be fully compatible with JVoxelizer.
This is harder todo, but also reduces the complexity a bit, since you do not have duplicate classnames to worry about.
A detailed tutorial for this porting type does not exist yet, but will be created shortly.
**In a nutshell:**

The general idea is to create a duplicate of your mod in a seperate sourceset or gradle sub-project, and make sure that this copy of your mod does not depend on Minecraft.
Then add a dependency on the JVoxelizer api, and port to it.
Remove all the duplicate code from your original.
Now wire the two up, by making the original depend on the Minecraft version specific jar of JVoxelizer, as well as on your copy.
Do not forget to shade both into your mods jar.
After that is setup, wire event handlers and initialization through to the right points in your copy, from the original.
An example of how this can be achieved with gradle-subprojects is: [BlockOut](https://github.com/ldtteam/BlockOut).
