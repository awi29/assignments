import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Heap {
public static int free_start;
public static int arr[];
static int t;
static int k;
public void createarray(int x) {
        arr = new int[x];
    }

static void get_free_start()
{
         for(int i =0;i<arr.length;i++)
         {
          if(arr[i]%100!=0)
          {
            free_start=i;
            break;
          }
         }
}
static void deallocate(int g)
{

   for(int i=g;i<arr.length;i++)
   {
    if(arr[i]==100)
    {
      arr[i]=0;
    }
    else
      break;
   }

   for(int i=0;i<arr.length;i++)
   {
    if(arr[i]%100!=0)
      arr[i]=0;
   }


   arr[g-1]=0;




}
    static int allocate_first(int g)
    {
      for(int i=0;i<arr.length;i++)
      {
        if(arr[i]%100!=0)
        {
          if(arr[i+1]==-1)
          {

            if(g>(arr[free_start]-3)&&g!=(arr[free_start]-1))
            {
              return -1;
            }
          }
            else
            {
              if(g>(arr[free_start]-1))
              {
                return -1;
              }
            }
          }
        }

      int u1=0;
         for(int i=0;i<arr.length;i++)
         {
          int c=0;
            if((arr[i+1]!=(100))&&(arr[i]!=(100)))
            {
              for(int j=i+1;j<g+i+1;j++)
                arr[j]=100;

              arr[i]=(g+1)*100;
              c++;
            }
            if(c==1)
            {
              u1=i+1;
              break;
            }
         }
         return u1;
    }



    static int allocate_best(int g)
    {
      for(int i=0;i<arr.length;i++)
      {
        if(arr[i]%100!=0)
        {
          if(arr[i+1]==-1)
          {

            if(g>(arr[free_start]-3)&&g!=(arr[free_start]-1))
            {
              return -1;
            }
          }
            else
            {
              if(g>(arr[free_start]-1))
              {
                return -1;
              }
            }
          }
        }

      int u1=0;
         for(int i=0;i<arr.length;i++)
         {
          int c=0;
            if((arr[i+1]!=(100))&&(arr[i]!=(100)))
            {
              for(int j=i+1;j<g+i+1;j++)
                arr[j]=100;

              arr[i]=(g+1)*100;
              c++;
            }
            if(c==1)
            {
              u1=i+1;
              break;
            }
         }
         return u1;
    }


    static void allocate_free_block_length()
    {

       for(int i=0;i<arr.length;i++)
       {
        int c=0;
        int count=0;
        int f=arr.length-1;
        if(arr[i]==-1)
          break;
        if(arr[i]==0)
        {
          for(int j=i+1;j<arr.length;j++)
          {
            if(c==1)
              break;

            if(arr[j]==0)
            {
                   count++;
            }
            else
              {
                c++;
               f= j;
              }
          }

        int u1=f;
        for(int k=u1;k<arr.length;k++)
        {
          if(arr[k]==-1)
          {
            u1=k-1;
            break;
          }
        }


          arr[i]=count+1;
          if(f<arr.length-1)
          {
            arr[i+1]=u1;
          }
          else
            arr[i+1]=-1;

          i=f;

       }
     }
    }


 static void allocate_free_block_length1()
    {

       for(int i=0;i<arr.length;i++)
       {

        int count=0;
        int g1=0;
        int r1=0;
        if(arr[i]==0)
        {
          //System.out.println("i"+i);
           int l=0;
          for(int j=i+1;j<arr.length;j++)
          {
               if(arr[j]==0)
               {
                r1=j;
                count++;
              }
              else
              {
                    g1=j;
                    break;
              }
          }
          if(r1==(arr.length-1))
          {
            g1=arr.length;
          }
                //System.out.println("count"+count);
          arr[i]=count+1;
          int y1=0;
          for(int j=g1;j<arr.length;j++)
          {
            if(arr[j]==0)
            {
              l=j;
              y1++;
              break;

            }
          }

          if(y1==0)
            l=arr.length;

            if(l==arr.length)
              arr[i+1]=-1;
            else
              arr[i+1]=l;

            i=l-1;
        }


     }
    }


static void print()
{
    for(int i=0;i<arr.length;i++)
    {
        if(arr[arr.length-i-1]%100==0&&arr[arr.length-i-1]!=100&&arr[arr.length-i-1]!=0)
        {
              int y1=arr[arr.length-i-1]/100;

               System.out.println("*************"+" "+y1+"
"+"**************");
        }
        else
        System.out.println("*************"+" "+arr[arr.length-i-1]+"
"+"**************");
    }
}
public static int y;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Heap nn=new Heap();
        free_start=0;
        System.out.println("************Welcome to Heap Activation
Record****************");
        System.out.println("Type the Length of Record you want to make");
         t=in.nextInt();
       nn.createarray(t);

       k=arr.length;
       System.out.println("Printing the Intial Array with 0 Allocation");
       nn.allocate_free_block_length();
       System.out.println();
       nn.print();


  System.out.println("Allocation Starts");

  System.out.println("Type 1 for Allocation");
  System.out.println("Type 2 for De-Allocation");
  System.out.println("Type 3 for Printing");
  System.out.println("Type 4 for Exit");


  int w2=0;
  int[] h1=new int[100];

  while(1==1)
  {
    nn.get_free_start();
      System.out.println("Type Your Option please");
     int w1=in.nextInt();
    if(w1==1)
    {
         System.out.println("Type number of Block you want to allocate");
                int s1;
       s1=in.nextInt();
       int o1=nn.allocate_first(s1);
       if(o1==-1)
       {
        System.out.println("Sorry cannot allocate type value again");
       }
       else
      h1[w2]=o1;

      nn.allocate_free_block_length();

      w2++;

    }
    else if(w1==2)
    {
           System.out.println("Type Index you want to de-allocate");
           int p=in.nextInt();
           nn.deallocate(h1[p]);


       nn.allocate_free_block_length1();
    }
    else if(w1==3)
    {
      nn.print();
    }
    else
    {
      System.exit(0);
    }
         System.out.println("The value of free_start is"+" "+free_start);
  }




    }
}
