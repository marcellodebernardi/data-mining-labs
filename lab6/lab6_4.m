%% Cell 1: Load some data.
load fisheriris; %Load classic flower dataset.
meas = zscore(meas);
X = meas(:,[1,2]); d = 2;
%X = meas; d = 4;
[sval,~,y]=unique(species);
idx=(y==2)|(y==3);
X = X(idx,:);
y = y(idx,:);
y(y==3)=1; y(y==2)=0;
Xtr = X(1:2:end,:);
Ytr = y(1:2:end); 
Xte = X(2:2:end,:);
Yte = y(2:2:end);

figure(4); clf; gscatter(X(:,1),X(:,2),y);  title('True Class Labels');

lx=-2.5:0.05:2.5;
[LX1,LX2]=meshgrid(lx,lx);                      %Generate a list of every single condition in order to plot the classification space.
LX=[LX1(:),LX2(:)];

%% Cell 2: Train Naive Bayes.
nb = fitcnb(Xtr, Ytr, 'Distribution', 'normal');
[~,pTrNB,~] = predict(nb,Xtr); predTr = pTrNB(:,2)>0.5; fprintf(1,'NB Train acc: %1.2f\n', sum(Ytr==predTr)/numel(Ytr));
[~,pTeNB,~] = predict(nb,Xte); predTe = pTeNB(:,2)>0.5; fprintf(1,'NB Test  acc: %1.2f\n', sum(Yte==predTe)/numel(Yte));
util_nbVizMulti(lx,LX,nb,Xtr,Ytr,2,0.5);

%% Cell 2B: Train LR.
w0 = zeros(1,size(Xtr,2)+1);
options = optimset('GradObj','on');
f    = @(w) util_lrlik_reg_2c(Ytr, Xtr, w);
[w,fval,eflag,out] = fminunc(f, w0, options);
pTrLR = util_lrclass_2c(Xtr,w); predTr = pTrLR>0.5; fprintf(1,'LR Train acc: %1.2f\n', sum(Ytr==predTr)/numel(Ytr));
pTeLR = util_lrclass_2c(Xte,w); predTe = pTeLR>0.5; fprintf(1,'LR Test acc: %1.2f\n',  sum(Yte==predTe)/numel(Yte));
util_lrViz(lx,LX,w,Xtr,Ytr,2,0.5);             %Visualise the space by coloring the background.

%% Cell 3: Apply trained LR/Naive bayes with different thresholds.
thr = 0.6;      %Try different values here and observe results.
predTr = pTrLR>thr; fprintf(1,'LR Train acc: %1.2f\n', sum(Ytr==predTr)/numel(Ytr));
predTe = pTeLR>thr; fprintf(1,'LR Test acc: %1.2f\n',  sum(Yte==predTe)/numel(Yte));
cmat = confusionmat(Yte,double(predTe))
util_lrViz(lx,LX,w,Xtr,Ytr,2,thr);             %Visualise the space by coloring the background.

predTr = pTrNB(:,2)>thr; fprintf(1,'NB Train acc: %1.2f\n', sum(Ytr==predTr)/numel(Ytr));
predTe = pTeNB(:,2)>thr; fprintf(1,'NB Test  acc: %1.2f\n', sum(Yte==predTe)/numel(Yte));
cmat = confusionmat(Yte,double(predTe))
util_nbVizMulti(lx,LX,nb,Xtr,Ytr,2,thr);

%% Cell 4;
% This code computes the confusion matrix, and TPR/FPR for NB and LR/MaxEnt.
% Add a loop over threshold to try a whole bunch of thresholds, and plot fpr against tpr to generate an roc curve.
% preallocate arrays
tpr_lr = zeros(101, 1);
fpr_lr = zeros(101, 1);
tpr_nb = zeros(101, 1);
fpr_nb = zeros(101, 1);
i = 1;

for thr = 0:0.01:1
    % logistic regression
    predTr = pTrLR>thr;
    predTe = pTeLR>thr;
    fprintf(1,'LR Train acc: %1.2f\n', sum(Ytr==predTr)/numel(Ytr));
    fprintf(1,'LR Test acc: %1.2f\n',  sum(Yte==predTe)/numel(Yte));
    cmat = confusionmat(Yte,double(predTe))
    tpr_lr(i) = cmat(2,2)/sum(Yte==1);
    fpr_lr(i) = cmat(1,2)/sum(Yte==0);

    % naive bayes
    predTr = pTrNB(:,2)>thr;
    predTe = pTeNB(:,2)>thr;
    fprintf(1,'NB Train acc: %1.2f\n', sum(Ytr==predTr)/numel(Ytr));
    fprintf(1,'NB Test  acc: %1.2f\n', sum(Yte==predTe)/numel(Yte));
    cmat = confusionmat(Yte,double(predTe))
    tpr_nb(i)=cmat(2,2)/sum(Yte==1);
    fpr_nb(i)=cmat(1,2)/sum(Yte==0);
    
    i = i + 1;
end

% plot
figure(1);clf;
plot(fpr_lr,tpr_lr);
title('LR-ROC');
		
figure(2);clf;
plot(fpr_nb, tpr_nb);
title('NB-ROC');

[~,~,~,aucLR]=perfcurve(Yte,pTeLR,1)
[~,~,~,aucNB]=perfcurve(Yte,pTeNB(:,2),1)

