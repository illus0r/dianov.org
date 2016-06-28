        import java.awt.image.BufferedImage;
        import java.io.File;
        import javax.activation.MimetypesFileTypeMap;
        import javax.imageio.ImageIO;
        import jenkins.*;
        import jenkins.model.*;
        import static groovy.io.FileType.FILES;
        
        int IMG_MAX_SIZE = 1000;
        boolean isError = false;
        
        def workspace = Jenkins.instance.getJob(this.binding.build.project.name).lastBuild.workspace;
        //assert imgExtentions.any { it == ".png" }
        //println workspace.dump();
        new File(workspace.remote).eachFileRecurse(FILES) {
          //imgExtentions
          if( it.name ==~ /([^\\s]+(\\.(?i)(jpg|png|gif|bmp))\$)/  ){
            //println it;
            def img = ImageIO.read(it);
            if( img.getWidth()>IMG_MAX_SIZE || img.getHeight()>IMG_MAX_SIZE ){
              println "ERROR:";
              println "Image \${it}";
              println "is \${ img.getWidth() }x\${ img.getWidth() } px. That's too much.";
              println "Please, scale it down. It shouldn't be bigger then \${ IMG_MAX_SIZE }x\${ IMG_MAX_SIZE } pixels.";
              isError = true;
            }
          }
        }
        if (isError == true){
          return 1;
        }
        return 0;
