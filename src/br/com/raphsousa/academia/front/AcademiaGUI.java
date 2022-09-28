/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.raphsousa.academia.front;

import br.com.raphsousa.academia.Base;
import br.com.raphsousa.academia.dao.AlunoDAO;
import br.com.raphsousa.academia.dao.ProfessorDAO;
import br.com.raphsousa.academia.dao.TreinoDAO;
import br.com.raphsousa.academia.enums.Genero;
import br.com.raphsousa.academia.modelo.bd.AcademiaBD;
import br.com.raphsousa.academia.modelo.entidades.Aluno;
import br.com.raphsousa.academia.modelo.entidades.Professor;
import br.com.raphsousa.academia.modelo.entidades.Treino;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author idrap
 */
public class AcademiaGUI extends javax.swing.JFrame {

    /**
     * Creates new form AcademiaGUI
     */
    public AcademiaGUI() {
        initComponents();
//        AcademiaBD.inicializar();
        populaTabelas();
        populaCombos();
        AutoCompleteDecorator.decorate(jcbAlunos);
        AutoCompleteDecorator.decorate(jcbProfessores);

    }

    private void populaTabelas() {
        populaTabelaAlunos();
        populaTabelaProfessores();
        populaTabelaTreinos(TreinoDAO.selecionarTodos());
    }

    private void populaTabelaAlunos() {
        String[] camposAlunos = {"Matricula", "Nome", "Idade",
            "Genero"};
        List<Aluno> alunos = AlunoDAO.selecionarTodos();
        String[][] dadosAlunos;
        dadosAlunos = new String[alunos.size()][camposAlunos.length];
        int posicao = 0;
        for (Aluno al : alunos) {
            String[] umAluno = new String[camposAlunos.length];
            umAluno[0] = String.valueOf(al.getId());
            umAluno[1] = al.getNome();
            umAluno[2] = String.valueOf(al.getIdade());
            umAluno[3] = al.getGenero().getGenero();
            dadosAlunos[posicao++] = umAluno;
        }
        DefaultTableModel modelo = new DefaultTableModel(
                dadosAlunos, camposAlunos);
        jtAlunos.setModel(modelo);
    }

    private void populaTabelaProfessores() {
        String[] camposProfessor = {"Id", "Nome"};
        List<Professor> professores = ProfessorDAO.selecionarTodos();
        String[][] dadosProfessores;
        dadosProfessores = new String[professores.size()][camposProfessor.length];
        int posicao = 0;
        for (Professor prof : professores) {
            String[] umAluno = new String[camposProfessor.length];
            umAluno[0] = String.valueOf(prof.getId());
            umAluno[1] = prof.getNome();
            dadosProfessores[posicao++] = umAluno;
        }
        DefaultTableModel modelo = new DefaultTableModel(
                dadosProfessores, camposProfessor);
        jtProfessores.setModel(modelo);
    }

    private void populaTabelaTreinos(List<Treino> treinos) {
        String[] camposTreino = {"Id", "matriculaAluno", "idProfessor",
            "titulo", "descricao"};
        String[][] dadosTreinos;
        dadosTreinos = new String[treinos.size()][camposTreino.length];
        int posicao = 0;
        for (Treino tr : treinos) {
            String[] umAluno = new String[camposTreino.length];
            umAluno[0] = String.valueOf(tr.getId());
            umAluno[1] = String.valueOf(tr.getAluno().getId());
            umAluno[2] = String.valueOf(tr.getProfessor().getId());
            umAluno[3] = tr.getTitulo();
            umAluno[4] = tr.getDescricao();
            dadosTreinos[posicao++] = umAluno;
        }
        DefaultTableModel modelo = new DefaultTableModel(
                dadosTreinos, camposTreino);
        jtTreinos.setModel(modelo);
    }

    private void populaCombos() {
        populaComboboxGenero();
        populaComboAlunos();
        populaComboProfessores();
    }

    private void populaComboboxGenero() {
        jcbGeneroAluno.removeAllItems();
        Genero[] arrayGenero = Genero.values();
        for (Genero gn : arrayGenero) {
            jcbGeneroAluno.addItem(gn.toString());
        }
    }

    private void populaComboAlunos() {
        jcbAlunos.removeAllItems();
        List<Aluno> listaAlunos = AlunoDAO.selecionarTodos();
        for (Aluno al : listaAlunos) {
            jcbAlunos.addItem(String.valueOf(al.getId()));
        }
    }

    private void populaComboProfessores() {
        jcbProfessores.removeAllItems();
        List<Professor> listaProfessores = ProfessorDAO.selecionarTodos();
        for (Professor prof : listaProfessores) {
            jcbProfessores.addItem(String.valueOf(prof.getId()));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlProfessor = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtProfessores = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txfNomeProfessor = new javax.swing.JTextField();
        btnAdicionaProfessor = new javax.swing.JButton();
        btnEditaProfessor = new javax.swing.JButton();
        btnDeletaProfessor = new javax.swing.JButton();
        pnlAluno = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAlunos = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        dtcAluno = new com.toedter.calendar.JDateChooser("dd/MM/yyyy" , "##/##/##" , ' ');
        jLabel10 = new javax.swing.JLabel();
        jcbGeneroAluno = new javax.swing.JComboBox<>();
        txfNomeAluno = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        btnDeletaAluno = new javax.swing.JButton();
        btnAlterarAluno = new javax.swing.JButton();
        btnAdicionaAluno = new javax.swing.JButton();
        pnlTreino = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtTreinos = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jcbProfessores = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jcbAlunos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txfTituloTreino = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        txaDescricaoTreino = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        btnAdicionarTreino = new javax.swing.JButton();
        btnAlterarTreino = new javax.swing.JButton();
        btnRemoverTreino = new javax.swing.JButton();
        btnSelecionaTreinoPorID = new javax.swing.JButton();
        txfSelecionaPorIdTreino = new javax.swing.JTextField();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jtProfessores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtProfessores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProfessoresMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtProfessores);

        jLabel6.setText("Nome");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txfNomeProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txfNomeProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        btnAdicionaProfessor.setText("Adicionar");
        btnAdicionaProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionaProfessorActionPerformed(evt);
            }
        });

        btnEditaProfessor.setText("Editar");
        btnEditaProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditaProfessorActionPerformed(evt);
            }
        });

        btnDeletaProfessor.setText("Deletar");
        btnDeletaProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletaProfessorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnAdicionaProfessor)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditaProfessor)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeletaProfessor)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionaProfessor)
                    .addComponent(btnEditaProfessor)
                    .addComponent(btnDeletaProfessor))
                .addGap(53, 53, 53))
        );

        javax.swing.GroupLayout pnlProfessorLayout = new javax.swing.GroupLayout(pnlProfessor);
        pnlProfessor.setLayout(pnlProfessorLayout);
        pnlProfessorLayout.setHorizontalGroup(
            pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProfessorLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        pnlProfessorLayout.setVerticalGroup(
            pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProfessorLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("Professor", pnlProfessor);

        jtAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "1", "2", "3", "4"
            }
        ));
        jtAlunos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtAlunosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtAlunos);

        jLabel8.setText("data Nascimento");

        jLabel10.setText("Genero");

        jcbGeneroAluno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino", "Outro", " " }));

        jLabel9.setText("Nome");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(txfNomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(dtcAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbGeneroAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dtcAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txfNomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jcbGeneroAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        btnDeletaAluno.setText("Deletar");
        btnDeletaAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletaAlunoActionPerformed(evt);
            }
        });

        btnAlterarAluno.setText("Editar");
        btnAlterarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarAlunoActionPerformed(evt);
            }
        });

        btnAdicionaAluno.setText("Adicionar");
        btnAdicionaAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionaAlunoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdicionaAluno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAlterarAluno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeletaAluno)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeletaAluno)
                    .addComponent(btnAlterarAluno)
                    .addComponent(btnAdicionaAluno))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlAlunoLayout = new javax.swing.GroupLayout(pnlAluno);
        pnlAluno.setLayout(pnlAlunoLayout);
        pnlAlunoLayout.setHorizontalGroup(
            pnlAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAlunoLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(pnlAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        pnlAlunoLayout.setVerticalGroup(
            pnlAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAlunoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Aluno", pnlAluno);

        jtTreinos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtTreinos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTreinosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtTreinos);

        jcbProfessores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Id do Professor");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbProfessores, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbProfessores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jcbAlunos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "223", "335", "445", "770", "410", "123" }));
        jcbAlunos.setToolTipText("");
        jcbAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAlunosActionPerformed(evt);
            }
        });

        jLabel1.setText("Matricula do Aluno");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jLabel3.setText("Titulo");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfTituloTreino, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfTituloTreino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txaDescricaoTreino.setColumns(20);
        txaDescricaoTreino.setRows(5);
        jScrollPane4.setViewportView(txaDescricaoTreino);

        jLabel4.setText("Descrição");

        btnAdicionarTreino.setText("Adicionar");
        btnAdicionarTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarTreinoActionPerformed(evt);
            }
        });

        btnAlterarTreino.setText("Alterar");
        btnAlterarTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarTreinoActionPerformed(evt);
            }
        });

        btnRemoverTreino.setText("Remover");
        btnRemoverTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverTreinoActionPerformed(evt);
            }
        });

        btnSelecionaTreinoPorID.setText("Selecionar por matricula");
        btnSelecionaTreinoPorID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionaTreinoPorIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSelecionaTreinoPorID)
                        .addGap(18, 18, 18)
                        .addComponent(txfSelecionaPorIdTreino, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(btnAdicionarTreino)
                                .addGap(18, 18, 18)
                                .addComponent(btnAlterarTreino))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(btnRemoverTreino)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfSelecionaPorIdTreino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSelecionaTreinoPorID)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnAdicionarTreino)
                                    .addComponent(btnAlterarTreino))
                                .addGap(18, 18, 18)
                                .addComponent(btnRemoverTreino)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlTreinoLayout = new javax.swing.GroupLayout(pnlTreino);
        pnlTreino.setLayout(pnlTreinoLayout);
        pnlTreinoLayout.setHorizontalGroup(
            pnlTreinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTreinoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTreinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3)
                    .addGroup(pnlTreinoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(222, 222, 222))
        );
        pnlTreinoLayout.setVerticalGroup(
            pnlTreinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTreinoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        jTabbedPane1.addTab("Treino", pnlTreino);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 921, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private Aluno getAlunoPorLinha(int linhaSelecionada) {
        String matriculaString = (String) jtAlunos.getValueAt(linhaSelecionada,
                0);
        int idInt = Integer.parseInt(matriculaString);

        String nomeSelecionado = (String) jtAlunos.getValueAt(linhaSelecionada,
                1);
        String generoSelecionado = (String) jtAlunos.getValueAt(linhaSelecionada,
                3);
        Aluno aluno = new Aluno(idInt, nomeSelecionado, Genero.getGenero(
                generoSelecionado));
        Date dataNasc = AlunoDAO.selecionarPorId(aluno.getId()).get(0)
                .getDataNascimento();
        aluno.setDataNascimento(dataNasc);
        return aluno;
    }

    private Professor getProfessorPorLinha(int linhaSelecionada) {
        String idString = (String) jtProfessores.getValueAt(linhaSelecionada, 0);
        String nomeProfessorSelecionado = (String) jtProfessores.getValueAt(
                linhaSelecionada, 1);

        int idInt = Integer.parseInt(idString);
        Professor professor = new Professor(idInt, nomeProfessorSelecionado);
        return professor;
    }

    private Treino getTreinoPorLinha(int linhaSelecionada) {
        String idString = (String) jtTreinos.getValueAt(linhaSelecionada, 0);
        int idInt = Integer.parseInt(idString);

        String matriculaAluno = (String) jtTreinos.getValueAt(linhaSelecionada, 1);
        int matriculaAlunoInt = Integer.parseInt(matriculaAluno);

        String idProfessor = (String) jtTreinos.getValueAt(linhaSelecionada, 2);
        int idProfessorInt = Integer.parseInt(idProfessor);

        String tituloTreino = (String) jtTreinos.getValueAt(linhaSelecionada, 3);
        String descTreino = (String) jtTreinos.getValueAt(linhaSelecionada, 4);

        Aluno aluno = new Aluno(matriculaAlunoInt);
        Professor professor = new Professor(idProfessorInt);
        Treino treino = new Treino(idInt, aluno, professor, tituloTreino, descTreino);

        return treino;
    }

    private void jcbAlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAlunosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbAlunosActionPerformed

    private void btnAdicionaAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionaAlunoActionPerformed
        String nomeAluno = txfNomeAluno.getText();
        Date dataNascimentoAluno = this.dtcAluno.getDate();
        String generoAlunoString = jcbGeneroAluno.getSelectedItem().toString();
        if (!(nomeAluno.isEmpty()) && !generoAlunoString.isEmpty()
                && dataNascimentoAluno != null) {
            Aluno alunoASerAdicionado = new Aluno(nomeAluno, dataNascimentoAluno,
                    Genero.getGenero(generoAlunoString));
            AlunoDAO.inserir(alunoASerAdicionado);
            populaTabelaAlunos();
            populaComboAlunos();
        } else {
            Base.mensagemDeErro("Nenhum campo pode ser nulo");
        }
    }//GEN-LAST:event_btnAdicionaAlunoActionPerformed

    private void btnAlterarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarAlunoActionPerformed
        int linhaSelecionada = jtAlunos.getSelectedRow();
        if (jtAlunos.isRowSelected(linhaSelecionada)) {
            Aluno alunoASerAlterado = getAlunoPorLinha(linhaSelecionada);

            String nomeAluno = txfNomeAluno.getText();
            Date dataNascimentoAluno = dtcAluno.getDate();
            String generoAlunoString = jcbGeneroAluno.getSelectedItem().toString();
            if (!(nomeAluno.isEmpty()) && !generoAlunoString.isEmpty()
                    && dataNascimentoAluno != null) {
                alunoASerAlterado.setNome(nomeAluno);
                alunoASerAlterado.setDataNascimento(dataNascimentoAluno);
                alunoASerAlterado.setGenero(Genero.getGenero(generoAlunoString));
                AlunoDAO.alterar(alunoASerAlterado);
                populaTabelaAlunos();
            } else {
                Base.mensagemDeErro("Nenhum campo pode ser nulo");
            }
        }
    }//GEN-LAST:event_btnAlterarAlunoActionPerformed

    private void btnDeletaAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletaAlunoActionPerformed
        int linhaSelecionada = jtAlunos.getSelectedRow();
        if (jtAlunos.isRowSelected(linhaSelecionada)) {
            Aluno aluno = getAlunoPorLinha(linhaSelecionada);
            AlunoDAO.remover(aluno);
            populaTabelaAlunos();
        }
    }//GEN-LAST:event_btnDeletaAlunoActionPerformed

    private void jtAlunosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtAlunosMouseClicked
        // TODO add your handling code here:

        int linhaSelecionada = jtAlunos.getSelectedRow();
        if (jtAlunos.isRowSelected(linhaSelecionada)) {
            Aluno aluno = getAlunoPorLinha(linhaSelecionada);
            txfNomeAluno.setText(aluno.getNome());
            dtcAluno.setDate(aluno.getDataNascimento());
            jcbGeneroAluno.setSelectedIndex(0);

            int size = jcbGeneroAluno.getItemCount();
            for (int i = 0; i < size; i++) {
                if (aluno.getGenero().toString().equalsIgnoreCase(
                        jcbGeneroAluno.getItemAt(i))) {
                    jcbGeneroAluno.setSelectedIndex(i);
                }
            }
        }
    }//GEN-LAST:event_jtAlunosMouseClicked

    private void btnAdicionaProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionaProfessorActionPerformed
        String nomeProfessor = txfNomeProfessor.getText();
        if (!nomeProfessor.isEmpty()) {
            Professor professorASerInserido = new Professor(nomeProfessor);
            ProfessorDAO.inserir(professorASerInserido);
            populaTabelaProfessores();
            populaComboProfessores();

        } else {
            Base.mensagemDeErro("Nenhum campo pode ser nulo");
        }

    }//GEN-LAST:event_btnAdicionaProfessorActionPerformed

    private void btnEditaProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditaProfessorActionPerformed
        int linhaSelecionada = jtProfessores.getSelectedRow();
        if (jtProfessores.isRowSelected(linhaSelecionada)) {
            Professor professorASerAlterado = getProfessorPorLinha(linhaSelecionada);
            String nomeProfessor = txfNomeProfessor.getText();
            if (!nomeProfessor.isEmpty()) {
                professorASerAlterado.setNome(nomeProfessor);
                ProfessorDAO.alterar(professorASerAlterado);
                populaTabelaProfessores();
            } else {
                Base.mensagemDeErro("Nenhum campo pode ser nulo");
            }
        }
    }//GEN-LAST:event_btnEditaProfessorActionPerformed

    private void jtProfessoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProfessoresMouseClicked
        int linhaSelecionada = jtProfessores.getSelectedRow();
        if (jtProfessores.isRowSelected(linhaSelecionada)) {
            Professor professor = getProfessorPorLinha(linhaSelecionada);
            txfNomeProfessor.setText(professor.getNome());
        }
    }//GEN-LAST:event_jtProfessoresMouseClicked

    private void btnDeletaProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletaProfessorActionPerformed
        int linhaSelecionada = jtProfessores.getSelectedRow();
        if (jtProfessores.isRowSelected(linhaSelecionada)) {
            Professor professor = getProfessorPorLinha(linhaSelecionada);
            ProfessorDAO.remover(professor);
            populaTabelaProfessores();
        }
    }//GEN-LAST:event_btnDeletaProfessorActionPerformed

    private void btnAdicionarTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarTreinoActionPerformed
        String tituloTreino = txfTituloTreino.getText();
        String descTreino = txaDescricaoTreino.getText();

        if (!tituloTreino.isEmpty() && !descTreino.isEmpty()) {
            String matriculaAlunoString = jcbAlunos.getSelectedItem().toString();
            int matriculaAlunoInt = Integer.parseInt(matriculaAlunoString);
            String idProfessorString = jcbProfessores.getSelectedItem().toString();
            int idProfessorInt = Integer.parseInt(idProfessorString);

            Aluno alunoAReceberTreino = new Aluno(matriculaAlunoInt);
            Professor professorADarTreino = new Professor(idProfessorInt);

            Treino treinoASerInserido = new Treino(alunoAReceberTreino,
                    professorADarTreino, tituloTreino, descTreino);

            TreinoDAO.inserir(treinoASerInserido);
//            populaTabelaTreinos();
            List<Treino> treinos = TreinoDAO.selecionarTodos();
            populaTabelaTreinos(treinos);
        } else {
            Base.mensagem("Nenhum campo pode ser nulo");
        }

    }//GEN-LAST:event_btnAdicionarTreinoActionPerformed

    private void btnAlterarTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarTreinoActionPerformed
        int linhaSelecionada = jtTreinos.getSelectedRow();
        if (jtTreinos.isRowSelected(linhaSelecionada)) {
            Treino treino = getTreinoPorLinha(linhaSelecionada);
            String tituloTreino = txfTituloTreino.getText();
            String descTreino = txaDescricaoTreino.getText();
            if (!tituloTreino.isEmpty() && !descTreino.isEmpty()) {
                treino.setTitulo(tituloTreino);
                treino.setDescricao(descTreino);

                String matriculaAlunoString = jcbAlunos.getSelectedItem().toString();
                int matriculaAlunoInt = Integer.parseInt(matriculaAlunoString);

                String idProfessorString = jcbProfessores.getSelectedItem().toString();
                int idProfessorInt = Integer.parseInt(idProfessorString);

                Aluno alunoAReceberTreino = new Aluno(matriculaAlunoInt);
                Professor professorADarTreino = new Professor(idProfessorInt);

                treino.setAluno(alunoAReceberTreino);
                treino.setProfessor(professorADarTreino);

                TreinoDAO.alterar(treino);
//                populaTabelaTreinos();
                List<Treino> treinos = TreinoDAO.selecionarTodos();
                populaTabelaTreinos(treinos);
            } else {
                Base.mensagemDeErro("Nenhum campo pode ser nulo");
            }
        }

    }//GEN-LAST:event_btnAlterarTreinoActionPerformed

    private void jtTreinosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTreinosMouseClicked
        int linhaSelecionada = jtTreinos.getSelectedRow();
        if (jtTreinos.isRowSelected(linhaSelecionada)) {
            Treino treino = getTreinoPorLinha(linhaSelecionada);
            txfTituloTreino.setText(treino.getTitulo());
            txaDescricaoTreino.setText(treino.getDescricao());

            int size = jcbAlunos.getItemCount();
            for (int i = 0; i < size; i++) {
                String idString = String.valueOf(treino.getAluno().getId());
                if (idString.equalsIgnoreCase(jcbAlunos.getItemAt(i))) {
                    jcbAlunos.setSelectedIndex(i);
                }
            }

            int sizeProfessores = jcbProfessores.getItemCount();
            for (int i = 0; i < sizeProfessores; i++) {
                String idString = String.valueOf(treino.getProfessor().getId());
                if (idString.equalsIgnoreCase(jcbProfessores.getItemAt(i))) {
                    jcbProfessores.setSelectedIndex(i);
                }
            }

        }
    }//GEN-LAST:event_jtTreinosMouseClicked

    private void btnRemoverTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverTreinoActionPerformed
        int linhaSelecionada = jtTreinos.getSelectedRow();
        if (jtTreinos.isRowSelected(linhaSelecionada)) {
            Treino treino = getTreinoPorLinha(linhaSelecionada);
            TreinoDAO.remover(treino);
//            populaTabelaTreinos();
            List<Treino> treinos = TreinoDAO.selecionarTodos();
            populaTabelaTreinos(treinos);
        }
    }//GEN-LAST:event_btnRemoverTreinoActionPerformed

    private void btnSelecionaTreinoPorIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionaTreinoPorIDActionPerformed
        // TODO add your handling code here:

        String idMatriculaString = txfSelecionaPorIdTreino.getText();
        if (!idMatriculaString.isBlank()) {
            int matriculaInt = Integer.parseInt(idMatriculaString);
            List<Treino> treinos = TreinoDAO.selecionarPorMatricula(matriculaInt);
            populaTabelaTreinos(treinos);
        } else {
            populaTabelaTreinos(TreinoDAO.selecionarTodos());
        }
    }//GEN-LAST:event_btnSelecionaTreinoPorIDActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AcademiaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AcademiaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AcademiaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AcademiaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AcademiaGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionaAluno;
    private javax.swing.JButton btnAdicionaProfessor;
    private javax.swing.JButton btnAdicionarTreino;
    private javax.swing.JButton btnAlterarAluno;
    private javax.swing.JButton btnAlterarTreino;
    private javax.swing.JButton btnDeletaAluno;
    private javax.swing.JButton btnDeletaProfessor;
    private javax.swing.JButton btnEditaProfessor;
    private javax.swing.JButton btnRemoverTreino;
    private javax.swing.JButton btnSelecionaTreinoPorID;
    private com.toedter.calendar.JDateChooser dtcAluno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> jcbAlunos;
    private javax.swing.JComboBox<String> jcbGeneroAluno;
    private javax.swing.JComboBox<String> jcbProfessores;
    private javax.swing.JTable jtAlunos;
    private javax.swing.JTable jtProfessores;
    private javax.swing.JTable jtTreinos;
    private javax.swing.JPanel pnlAluno;
    private javax.swing.JPanel pnlProfessor;
    private javax.swing.JPanel pnlTreino;
    private javax.swing.JTextArea txaDescricaoTreino;
    private javax.swing.JTextField txfNomeAluno;
    private javax.swing.JTextField txfNomeProfessor;
    private javax.swing.JTextField txfSelecionaPorIdTreino;
    private javax.swing.JTextField txfTituloTreino;
    // End of variables declaration//GEN-END:variables
}
