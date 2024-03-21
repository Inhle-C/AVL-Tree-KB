JFLAGS = -g
JC = /usr/bin/javac

.SUFFIXES: .java .class
BINDIR = bin
SRCDIR = src

$(BINDIR)/%.class: $(SRCDIR)/%.java
	$(JC) -d $(BINDIR) -cp $(BINDIR) $<

.java.class:
	$(JC) $(JFLAGS) $*.java

SRC_FILES = Generics.java BSTNode.java BinaryTree.java AVLTree.java GenericsKbAVLApp.java 
JAVADOC = doc

CLASSES= \
Generics.java \
BSTNode.java \
BinaryTree.java \
AVLTree.java \
GenericsKbAVLApp.java

OUTPUT_FILE = output.txt

CLASS_FILES= $(CLASSES:%.java=$(BINDIR)/%.class)

default: classes run

classes: $(CLASS_FILES)

javadoc: $(SRCDIR)
	echo "Generating Javadoc..."
	echo "Source directory: $(SRCDIR)"
	mkdir -p $(JAVADOC)
	javadoc -d $(JAVADOC) $(SRCDIR)

compile: $(CLASS_FILES)

clean:
	$(RM) $(BINDIR)/*.class $(OUTPUT_FILE)

run:
	java -cp $(BINDIR) GenericsKbAVLApp >> $(OUTPUT_FILE)

