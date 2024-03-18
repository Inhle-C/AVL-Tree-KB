JFLAGS = -g
JC = /usr/bin/javac

.SUFFIXES: .java .class
BINDIR = bin
SRCDIR = src

$(BINDIR)/%.class: $(SRCDIR)/%.java
	$(JC) -d $(BINDIR) -cp $(BINDIR) $<

.java.class:
	$(JC) $(JFLAGS) $*.java

SRC_FILES = BinaryTree.java BSTNode.java Generics.java GenericsKbAVLApp.java AVLTree.java
JAVADOC = doc

CLASSES= \
BinaryTree.java \
BSTNode.java \
Generics.java \
AVLTree.java \
GenericsKbAVLApp.java

OUTPUT_FILE = output.txt

CLASS_FILES= $(CLASSES:%.java=$(BINDIR)/%.class)

default: classes run

classes: $(CLASS_FILES)

javadoc: $(SRC_FILES)
	mkdir -p $(JAVADOC)
	javadoc -d $(JAVADOC) $(SRC_FILES)

compile: $(CLASS_FILES)

clean:
	$(RM) $(BINDIR)/*.class $(OUTPUT_FILE)

run:
	java -cp $(BINDIR) GenericsKbAVLApp > $(OUTPUT_FILE)

