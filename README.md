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

### What about porting? Let's do this!
Okey when it comes to using and/or porting a mod to JVoxelizing, there are two ways todo this.
- Dynamic
- Straight.

#### Dynamic porting
With dynamic porting 